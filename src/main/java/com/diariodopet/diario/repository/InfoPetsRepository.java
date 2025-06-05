package com.diariodopet.diario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diariodopet.diario.model.InformationTutorPets;

public interface InfoPetsRepository extends JpaRepository<InformationTutorPets, Long> {
}
