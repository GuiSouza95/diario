package com.diariodopet.diario.service.implementation;

import com.diariodopet.diario.DTO.PhotosDTO;
import com.diariodopet.diario.model.Photos;
import com.diariodopet.diario.repository.PhotosRepository;
import com.diariodopet.diario.service.PhotosService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotosServiceImpl implements PhotosService {

    private final PhotosRepository photoRepository;

    @Override
    public Photos savePhoto(Photos photo) {
        return photoRepository.save(photo);
    }

    @Override
    public List<Photos> getPhotosByVisitId(Long visitId) {
        return photoRepository.findByVisitId(visitId);
    }

    @Override
    public PhotosDTO convertToDTO(Photos photo) {
        return PhotosDTO.builder()
                .id(photo.getId())
                .urlPhotos(photo.getUrlPhotos())
                .legend(photo.getLegend())
                .build();
    }

    @Override
    public List<PhotosDTO> convertToDTOList(List<Photos> photos) {
        return photos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}