package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.*;
import com.aleksa.springbootcvgenerator.service.ICVTemplateService;
import com.aleksa.springbootcvgenerator.service.IFieldService;
import com.aleksa.springbootcvgenerator.service.IObtainService;
import com.aleksa.springbootcvgenerator.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/obtain")
public class ObtainController {
    @Autowired
    private IObtainService obtainService;
    @Autowired
    private ICVTemplateService cvTemplateService;
    @Autowired
    private ISectionService sectionService;


    @PostMapping
    public ResponseEntity<?> saveObtain(@RequestBody Obtain obtain){

        CVTemplateSectionKey cvTemplateSectionKey=new CVTemplateSectionKey(obtain.getCvTemplate().getId(),obtain.getSection().getId());
        obtain.setId(cvTemplateSectionKey);
        Optional<CVTemplate> cvTemplate=cvTemplateService.findById(obtain.getCvTemplate().getId());
        Optional<Section> section=sectionService.findById(obtain.getSection().getId());
        obtain.setCvTemplate(cvTemplate.get());
        obtain.setSection(section.get());

        //cvTemplate.get().addObtain(obtain);
        //section.get().addObtain(obtain);
        return new ResponseEntity<>(obtainService.saveObtain(obtain), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteObtain(@PathVariable CVTemplateSectionKey id){
        obtainService.deleteObtain(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllObtains(){


        return new ResponseEntity<>(obtainService.findAll(),HttpStatus.OK);
    }
}
