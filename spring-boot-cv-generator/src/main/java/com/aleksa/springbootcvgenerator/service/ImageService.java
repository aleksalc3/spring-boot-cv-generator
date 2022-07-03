package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.ImageModel;
import com.aleksa.springbootcvgenerator.repository.IImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService{

    private IImageRepository imageRepository;
    public ImageService(IImageRepository _imageRepository) {
        this.imageRepository = _imageRepository;

    }
    @Override
    public ImageModel save(ImageModel imageModel) {
        return this.imageRepository.save(imageModel);
    }

    @Override
    public Optional<ImageModel> findById(Long id) {
        return this.imageRepository.findById(id);
    }

    @Override
    public Long getMaxId() {
        return this.imageRepository.getMaxId();
    }
}
