package com.diariodopet.diario.DTO;

import lombok.*;
import com.diariodopet.diario.model.Visits;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportsDTO {
    private Long id;
    private Visits visit;
    private String observation;
    private String eventVisit;
}