package com.diariodopet.diario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_photos", nullable = false, unique = true)
    private String urlPhotos;

    @Column(name = "legend")
    private String legend;

    @ManyToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visits visit;
}