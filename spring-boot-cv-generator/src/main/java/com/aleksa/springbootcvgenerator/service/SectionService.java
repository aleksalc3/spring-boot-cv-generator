package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.Section;
import com.aleksa.springbootcvgenerator.repository.ISectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService implements ISectionService{
    private final ISectionRepository sectionRepository;


    public SectionService(ISectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;

    }

    @Override
    public Section saveSection(Section section) {

        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public List<Section> findAll() {

        return sectionRepository.findAll();
    }

    @Override
    public Optional<Section> findById(Long id) {
        return sectionRepository.findById(id);
    }
}
