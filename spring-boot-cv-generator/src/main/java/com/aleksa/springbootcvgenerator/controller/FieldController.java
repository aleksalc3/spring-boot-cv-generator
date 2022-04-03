package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.Field;

import com.aleksa.springbootcvgenerator.service.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/field")
public class FieldController {

    @Autowired
    private IFieldService fieldService;

    @PostMapping
    public ResponseEntity<?> saveField(@RequestBody Field field){

        return new ResponseEntity<>(fieldService.saveField(field), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteField(@PathVariable Long id){
        fieldService.deleteField(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllFields() {
        return new ResponseEntity<>(fieldService.findAll(), HttpStatus.OK);
    }
}
