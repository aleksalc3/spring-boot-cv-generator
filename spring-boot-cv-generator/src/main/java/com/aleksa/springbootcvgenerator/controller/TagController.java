package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.Tag;
import com.aleksa.springbootcvgenerator.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tag")
public class TagController {
    @Autowired
    private ITagService tagService;

    @PostMapping
    public ResponseEntity<?> saveTag(@RequestBody Tag tag){
        return new ResponseEntity<>(tagService.saveTag(tag), HttpStatus.CREATED);
    }
    @DeleteMapping("{tagId}")
    public ResponseEntity<?> deleteTag(@PathVariable Long tagId){
        tagService.deleteTag(tagId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTags(){

        return new ResponseEntity<>(tagService.findAllTags(),HttpStatus.OK);
    }

}
