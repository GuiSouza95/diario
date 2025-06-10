package com.diariodopet.diario.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diariodopet.diario.DTO.PhotosDTO;
import com.diariodopet.diario.DTO.VisitsDTO;
import com.diariodopet.diario.model.Visits;
import com.diariodopet.diario.repository.VisitsRepository;
import com.diariodopet.diario.service.PhotosService;
import com.diariodopet.diario.service.VisitsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitsServiceImpl implements VisitsService {

private final VisitsRepository visitRepository;
    private final PhotosService photoService;

    @Override
    public Visits saveVisit(Visits visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Optional<Visits> getVisitById(Long id) {
        return visitRepository.findById(id);
    }

    @Override
    public List<Visits> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public VisitsDTO convertToDTO(Visits visit) {
        List<PhotosDTO> photosDTO = photoService.convertToDTOList(photoService.getPhotosByVisitId(visit.getId()));
        return VisitsDTO.builder()
                .id(visit.getId())
                .petId(visit.getPet().getId())
                .petsitterId(visit.getPetsitter().getId())
                .dateVisit(visit.getDateVisit())
                .hourInit(visit.getHourInit())
                .hourEnd(visit.getHourEnd())
                .behavior(visit.getBehavior())
                .photos(photosDTO)
                .build();
    }

    @Override
    public List<VisitsDTO> convertToDTOList(List<Visits> visits) {
        return visits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Visits> getVisitsByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return visitRepository.findByDateVisit(localDate);
    }
}