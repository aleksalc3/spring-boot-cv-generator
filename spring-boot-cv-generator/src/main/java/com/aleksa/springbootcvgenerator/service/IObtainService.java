package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.CVTemplateSectionKey;
import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.Obtain;

import java.util.List;

public interface IObtainService {
    Obtain saveObtain(Obtain obtain);
    void deleteObtain(CVTemplateSectionKey id);
    List<Obtain> findAll();
}
