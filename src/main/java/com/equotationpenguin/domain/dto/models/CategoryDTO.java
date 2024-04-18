package com.equotationpenguin.domain.dto.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;

    @NotNull(message = "La categoria no puede ser nula")
    @NotBlank(message = "El atributo no puede ir vacio")
    private String nameCategory;
}
