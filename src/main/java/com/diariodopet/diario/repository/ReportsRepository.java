package com.diariodopet.diario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diariodopet.diario.model.Reports;

public interface ReportsRepository extends JpaRepository<Reports, Long> {
}
