package com.diariodopet.diario.service;

import com.diariodopet.diario.model.Visits;
import java.util.List;
import java.util.Optional;

public interface VisitsService {
    Visits saveVisit(Visits visit);
    Optional<Visits> getVisitById(Long id);
    List<Visits> getAllVisits();
    void deleteVisit(Long id);
}