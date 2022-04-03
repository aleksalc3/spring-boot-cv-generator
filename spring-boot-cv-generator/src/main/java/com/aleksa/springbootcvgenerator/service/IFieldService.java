package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.Field;


import java.util.List;

public interface IFieldService {
    Field saveField(Field field);
    void deleteField(Long id);
    List<Field> findAll();

}
