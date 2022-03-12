package com.aleksa.springbootcvgenerator.service;


import com.aleksa.springbootcvgenerator.model.Tag;
import com.aleksa.springbootcvgenerator.repository.ITagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService{
    private final ITagRepository tagRepository;

    public TagService(ITagRepository tagRepository){
        this.tagRepository=tagRepository;
    }
    @Override
    public Tag saveTag(Tag tag){

        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id){

        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> findAllTags(){
        return tagRepository.findAll();
    }
}
