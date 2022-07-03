package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.CVTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICVTemplateRepository extends JpaRepository<CVTemplate,Long> {

    @Query("select MAX(c.id) from CVTemplate c")
    Long getMaxId();

    @Override
    void deleteById(Long template_id);
}
