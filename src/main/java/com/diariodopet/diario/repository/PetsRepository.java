package com.diariodopet.diario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diariodopet.diario.model.Pets;

public interface PetsRepository extends JpaRepository<Pets, Long>{
    List<Pets> findByTutorId(Long tutorId);
}