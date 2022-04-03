package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.CVTemplateSectionKey;
import com.aleksa.springbootcvgenerator.model.Obtain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObtainRepository extends JpaRepository<Obtain, CVTemplateSectionKey> {

}
