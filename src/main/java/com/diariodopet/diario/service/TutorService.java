package com.diariodopet.diario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Tutores;

@Service
public interface TutorService {
    Tutores saveTutor(Tutores tutor);
    List<Tutores> getAllTutores();
    Optional<Tutores> getTutorById(Long id);
    Optional<Tutores> getTutorByEmail(String email);
    void deleteTutor(Long id);
}
