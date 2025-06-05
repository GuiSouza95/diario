package com.diariodopet.diario.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoPetsDTO {
    private Long petId;
    private String infoSpecial;
    private String description;
}