package com.diariodopet.diario.service;

import com.diariodopet.diario.model.Reports;
import java.util.List;
import java.util.Optional;

public interface ReportsService {
    Reports saveReport(Reports report);
    List<Reports> getAllReports();
    Optional<Reports> getReportById(Long id);
    void deleteReport(Long id);
}