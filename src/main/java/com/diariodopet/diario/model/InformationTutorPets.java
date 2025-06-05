package com.diariodopet.diario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "info_pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationTutorPets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pets_id", nullable = false)
    private Pets pets;

    @Column(name = "info_special")
    private String infoSpecial;

    private String description;
}
