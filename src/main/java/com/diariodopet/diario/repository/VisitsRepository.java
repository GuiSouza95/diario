package com.diariodopet.diario.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diariodopet.diario.model.Visits;

public interface VisitsRepository extends JpaRepository<Visits, Long> {
    List<Visits> findByDateVisit(LocalDate date);
}
