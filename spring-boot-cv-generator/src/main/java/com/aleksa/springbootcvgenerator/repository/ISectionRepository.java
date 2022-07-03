package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.Field;
import com.aleksa.springbootcvgenerator.model.Role;
import com.aleksa.springbootcvgenerator.model.Section;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface ISectionRepository extends JpaRepository<Section,Long> {
    @Query("select MAX(s.id) from Section s")
    Long getMaxId();

    @Query("FROM Section ORDER BY id ASC")
    List<Section> findAll();


}
