package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.repository.IFieldRepository;
import com.aleksa.springbootcvgenerator.repository.ISectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService implements IFieldService{

    private final IFieldRepository fieldRepository;

    public FieldService(IFieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }
    @Override
    public Field saveField(Field field) {
        return fieldRepository.save(field);
    }

    @Override
    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }

    @Override
    public List<Field> findAll() {
        return fieldRepository.findAll();
    }




}
