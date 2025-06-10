package com.diariodopet.diario.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "petSitter_id", nullable = false)
    private Petsitters petsitter;

    @Column(name = "date_visit", nullable = false)
    private LocalDate dateVisit;

    @Column(name = "hour_init", nullable = false)
    private LocalTime hourInit;

    @Column(name = "hour_end", nullable = false)
    private LocalTime hourEnd;

    @Column(name = "behavior")
    private String behavior;

    @OneToOne(mappedBy = "visit")
    private Reports reports;
}