package com.diariodopet.diario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diariodopet.diario.model.Visits;

public interface VisitsRepository extends JpaRepository<Visits, Long> {
}
