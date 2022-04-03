package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.CVTemplate;
import com.aleksa.springbootcvgenerator.service.ICVTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/cvtemplate")
public class CVTemplateController {
    @Autowired
    private ICVTemplateService cvTemplateService;

    @PostMapping
    public ResponseEntity<?> saveCVTemplate(@RequestBody CVTemplate cvTemplate){
        cvTemplate.setDateOfCreation( LocalDate.now());
        return new ResponseEntity<>(cvTemplateService.saveCVTemplate(cvTemplate), HttpStatus.CREATED);
    }

    @DeleteMapping("{template_id}")
    public ResponseEntity<?> deleteCVTemplate(@PathVariable Long templateId){
        cvTemplateService.deleteCVTemplate(templateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCVTemplates(){
        return new ResponseEntity<>(cvTemplateService.findAll(),HttpStatus.OK);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<?> getCvTemplate(@PathVariable Long id){
        return new ResponseEntity<>(cvTemplateService.findById(id),HttpStatus.OK);
    }

}
