package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.CVTemplate;
import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.ImageModel;
import com.aleksa.springbootcvgenerator.model.Section;
import com.aleksa.springbootcvgenerator.repository.IImageRepository;
import com.aleksa.springbootcvgenerator.service.ICVTemplateService;
import com.aleksa.springbootcvgenerator.service.IFieldService;
import com.aleksa.springbootcvgenerator.service.IImageService;
import com.aleksa.springbootcvgenerator.service.ISectionService;
import liquibase.util.FileUtil;
import liquibase.util.file.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/cvtemplate")
public class CVTemplateController {
    @Autowired
    private ICVTemplateService cvTemplateService;
    @Autowired
    private ISectionService sectionService;

    @Autowired
    private IFieldService fieldService;

    @Autowired
    private IImageService imageService;

    @PostMapping
    public ResponseEntity<?> saveCVTemplate(@RequestBody CVTemplate cvTemplate){
        cvTemplate.setDateOfCreation( LocalDate.now());
        List<Section> sections=new ArrayList<>();
        for(Section s:cvTemplate.getSections()){
            sections.add(s);
        }
        cvTemplate.setSections(null);

        Long imgId=imageService.getMaxId();
        Optional<ImageModel> imageModel=imageService.findById(imgId);

        cvTemplate.setImageModel(imageModel.get());
        cvTemplateService.saveCVTemplate(cvTemplate);

        for(Section s:sections){
            s.setId(null);
            List<Field> fields=new ArrayList<>();
            for(Field f:s.getFields()){
                fields.add(f);
            }
            s.setFields(null);
            s.setTemplateId(cvTemplateService.getMaxId());
            sectionService.saveSection(s);
            for(Field f:fields){
                f.setId(null);
                f.setSectionId(sectionService.getMaxId());
                fieldService.saveField(f);
            }
            Collections.sort(fields);
            s.setFields(fields);

        }
        Collections.sort(sections);
        cvTemplate.setSections(sections);



        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping(path ="{template_id}")
    public ResponseEntity<?> deleteCVTemplate( @PathVariable Long template_id){

        cvTemplateService.deleteCVTemplate(template_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCVTemplates(){

        return new ResponseEntity<>(cvTemplateService.findAll(),HttpStatus.OK);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<?> getCvTemplate(@PathVariable Long id){

    Optional<CVTemplate> cvTemplate=cvTemplateService.findById(id);
        Collections.sort(cvTemplate.get().getSections());
        for(Section s:cvTemplate.get().getSections()){
            Collections.sort(s.getFields());
        }

        return new ResponseEntity<>(cvTemplate,HttpStatus.OK);
    }

}
