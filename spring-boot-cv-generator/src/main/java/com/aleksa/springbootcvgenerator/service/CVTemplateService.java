package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.CVTemplate;
import com.aleksa.springbootcvgenerator.repository.ICVTemplateRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CVTemplateService implements ICVTemplateService{
    private final ICVTemplateRepository cvTemplateRepository;

    public CVTemplateService(ICVTemplateRepository icvTemplateRepository){
        this.cvTemplateRepository=icvTemplateRepository;
    }

    @Override
    public CVTemplate saveCVTemplate(CVTemplate cvTemplate) {
        return cvTemplateRepository.save(cvTemplate);
    }

    @Override
    public void deleteCVTemplate(Long id) {
         cvTemplateRepository.deleteById(id);
    }

    @Override
    public List<CVTemplate> findAll() {
        return cvTemplateRepository.findAll();
    }

    @Override
    public Optional<CVTemplate> findById(Long id) {
        return cvTemplateRepository.findById(id);
    }
}
