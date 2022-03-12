package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.Tag;

import java.util.List;

public interface ITagService {
    Tag saveTag(Tag tag);

    void deleteTag(Long id);

    List<Tag> findAllTags();
}
