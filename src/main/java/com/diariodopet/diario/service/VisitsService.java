package com.diariodopet.diario.service;

import com.diariodopet.diario.DTO.VisitsDTO;
import com.diariodopet.diario.model.Visits;
import java.util.List;
import java.util.Optional;

public interface VisitsService {
    Visits saveVisit(Visits visit);
    Optional<Visits> getVisitById(Long id);
    List<Visits> getAllVisits();
    List<Visits> getVisitsByDate(String date);
    void deleteVisit(Long id);
    VisitsDTO convertToDTO(Visits visit);
    List<VisitsDTO> convertToDTOList(List<Visits> visits);
}