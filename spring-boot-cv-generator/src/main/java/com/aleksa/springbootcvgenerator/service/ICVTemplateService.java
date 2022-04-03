package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.CVTemplate;

import java.util.List;
import java.util.Optional;

public interface ICVTemplateService {
    CVTemplate saveCVTemplate(CVTemplate cvTemplate);
    void deleteCVTemplate(Long id);
    List<CVTemplate> findAll();
    Optional<CVTemplate> findById(Long id);
}
