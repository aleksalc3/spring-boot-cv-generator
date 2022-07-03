package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.CVTemplate;
import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.Section;
import com.aleksa.springbootcvgenerator.repository.ICVTemplateRepository;
import com.aleksa.springbootcvgenerator.repository.IFieldRepository;
import com.aleksa.springbootcvgenerator.repository.ISectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void deleteCVTemplate(Long template_id) {

         cvTemplateRepository.deleteById(template_id);
    }

    @Override
    public List<CVTemplate> findAll() {
        return cvTemplateRepository.findAll();
    }

    @Override
    public Optional<CVTemplate> findById(Long id) {
        return cvTemplateRepository.findById(id);
    }

    @Override
    public Long getMaxId(){return cvTemplateRepository.getMaxId();}
}
