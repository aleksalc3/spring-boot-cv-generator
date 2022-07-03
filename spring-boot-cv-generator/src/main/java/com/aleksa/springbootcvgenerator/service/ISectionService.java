package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.Section;

import java.util.List;
import java.util.Optional;

public interface ISectionService {
    Section saveSection(Section Section);
    void deleteSection(Long id);
    List<Section> findAll();
    Optional<Section> findById(Long id);
    Long getMaxId();
}
