package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFieldRepository extends JpaRepository<Field,Long> {

}
