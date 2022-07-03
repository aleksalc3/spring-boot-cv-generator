package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.ImageModel;

import java.util.Optional;

public interface IImageService {
    ImageModel save(ImageModel imageModel);
    Optional<ImageModel> findById(Long id);
    Long getMaxId();
}
