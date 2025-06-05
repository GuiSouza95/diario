package com.diariodopet.diario.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Visits;
import com.diariodopet.diario.repository.VisitsRepository;
import com.diariodopet.diario.service.VisitsService;

@Service
public class VisitsServiceImpl implements VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;

    @Override
    public Visits saveVisit(Visits visit) {
        return visitsRepository.save(visit);
    }

    @Override
    public Optional<Visits> getVisitById(Long id) {
        return visitsRepository.findById(id);
    }

    @Override
    public List<Visits> getAllVisits() {
        return visitsRepository.findAll();
    }

    @Override
    public void deleteVisit(Long id) {
        visitsRepository.deleteById(id);
    }
}