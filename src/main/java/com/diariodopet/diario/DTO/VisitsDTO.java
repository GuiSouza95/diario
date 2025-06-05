package com.diariodopet.diario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class VisitsDTO {
    private Long petId;
    private Long petsitterId;
    private LocalDate dateVisit;
    private LocalTime hourInit;
    private LocalTime hourEnd;
}