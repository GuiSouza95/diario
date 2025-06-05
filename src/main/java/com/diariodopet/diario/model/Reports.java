package com.diariodopet.diario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "report")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visits visit;

    @Column(name = "obs")
    private String observation;

    @Column(name = "event_visit", columnDefinition = "TEXT")
    private String eventVisit;
}