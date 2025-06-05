package com.diariodopet.diario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diariodopet.diario.model.Tutores;
import java.util.Optional;


public interface TutorRepository extends JpaRepository<Tutores, Long>{
    Optional<Tutores> findByEmail(String email);
}
