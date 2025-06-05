package com.diariodopet.diario.service.implementation;

import com.diariodopet.diario.model.Reports;
import com.diariodopet.diario.repository.ReportsRepository;
import com.diariodopet.diario.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportsServiceImpl implements ReportsService {

    private final ReportsRepository reportsRepository;

    @Autowired
    public ReportsServiceImpl(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    @Override
    public Reports saveReport(Reports report) {
        return reportsRepository.save(report);
    }

    @Override
    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }

    @Override
    public Optional<Reports> getReportById(Long id) {
        return reportsRepository.findById(id);
    }

    @Override
    public void deleteReport(Long id) {
        reportsRepository.deleteById(id);
    }
}