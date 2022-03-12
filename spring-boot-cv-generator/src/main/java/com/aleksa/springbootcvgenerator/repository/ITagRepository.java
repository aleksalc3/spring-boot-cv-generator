package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag,Long> {

}
