package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.CVTemplateSectionKey;
import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.Obtain;
import com.aleksa.springbootcvgenerator.repository.IObtainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtainService implements IObtainService{
    private final IObtainRepository obtainRepository;

    public ObtainService(IObtainRepository obtainRepository) {

        this.obtainRepository = obtainRepository;
    }


    @Override
    public Obtain saveObtain(Obtain obtain) {
        return obtainRepository.save(obtain);
    }

    @Override
    public void deleteObtain(CVTemplateSectionKey id) {
        obtainRepository.deleteById(id);
    }

    @Override
    public List<Obtain> findAll() {
        return obtainRepository.findAll();
    }
}
