package com.diariodopet.diario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diariodopet.diario.model.Photos;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
    List<Photos> findByVisitId(Long visitID);
}