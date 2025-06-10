package com.diariodopet.diario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitsDTO {
    private Long id;
    private Long petId;
    private Long petsitterId;
    private LocalDate dateVisit;
    private LocalTime hourInit;
    private LocalTime hourEnd;
    private String behavior;
    private String relato;
    private String comportamento;
    private List<PhotosDTO> photos;
    private String eventVisit;
}