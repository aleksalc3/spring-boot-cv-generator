package com.aleksa.springbootcvgenerator.controller;


import com.aleksa.springbootcvgenerator.model.Section;
import com.aleksa.springbootcvgenerator.service.IFieldService;
import com.aleksa.springbootcvgenerator.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/section")
public class SectionController {
    @Autowired
    private ISectionService sectionService;
    private IFieldService fieldService;

    @PostMapping
    public ResponseEntity<?> saveSection(@RequestBody Section section){

        return new ResponseEntity<>(sectionService.saveSection(section), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSection(@PathVariable Long id){
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllSections(){


        return new ResponseEntity<>(sectionService.findAll(),HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> getSection(@PathVariable Long id){
        return new ResponseEntity<>(sectionService.findById(id),HttpStatus.OK);
    }


}
