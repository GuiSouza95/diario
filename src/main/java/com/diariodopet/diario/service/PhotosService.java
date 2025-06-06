package com.diariodopet.diario.service;

import com.diariodopet.diario.DTO.PhotosDTO;
import com.diariodopet.diario.model.Photos;
import java.util.List;

public interface PhotosService {
    Photos savePhoto(Photos photo);
    List<Photos> getPhotosByVisitId(Long visitId);
    PhotosDTO convertToDTO(Photos photo);
    List<PhotosDTO> convertToDTOList(List<Photos> photos);
}