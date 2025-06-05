package com.diariodopet.diario.service.implementation;

import com.diariodopet.diario.model.Photos;
import com.diariodopet.diario.repository.PhotosRepository;
import com.diariodopet.diario.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotosServiceImpl implements PhotosService {

    private final PhotosRepository photosRepository;

    @Autowired
    public PhotosServiceImpl(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    @Override
    public Photos savePhoto(Photos photo) {
        return photosRepository.save(photo);
    }

    @Override
    public List<Photos> getAllPhotos() {
        return photosRepository.findAll();
    }

    @Override
    public Optional<Photos> getPhotoById(Long id) {
        return photosRepository.findById(id);
    }

    @Override
    public void deletePhoto(Long id) {
        photosRepository.deleteById(id);
    }
}