package com.informatorio.festmovies.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CategoryDTO {
    private Long id;
    @NotBlank
    private String name;
}
