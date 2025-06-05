package com.diariodopet.diario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diariodopet.diario.model.Petsitters;

public interface PetsitterRepository extends JpaRepository<Petsitters, Long>{
    Optional<Petsitters> findByEmail(String email);
}
