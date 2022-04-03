package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {

}
