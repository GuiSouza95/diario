package com.diariodopet.diario.DTO;

import lombok.*;
import com.diariodopet.diario.model.Visits;

@Data
@Builder
public class PhotosDTO {
    private Long id;
    private String urlPhotos;
    private String legend;
    private Visits visit;
}