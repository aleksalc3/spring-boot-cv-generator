package com.aleksa.springbootcvgenerator.repository;

import com.aleksa.springbootcvgenerator.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);

    @Query("select MAX(c.id) from ImageModel c")
    Long getMaxId();
}
