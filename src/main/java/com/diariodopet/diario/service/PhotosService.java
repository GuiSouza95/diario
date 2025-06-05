package com.diariodopet.diario.service;

import com.diariodopet.diario.model.Photos;
import java.util.List;
import java.util.Optional;

public interface PhotosService {
    Photos savePhoto(Photos photo);
    List<Photos> getAllPhotos();
    Optional<Photos> getPhotoById(Long id);
    void deletePhoto(Long id);
}