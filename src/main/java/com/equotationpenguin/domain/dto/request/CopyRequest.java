package com.equotationpenguin.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CopyRequest {

    @NotNull
    @Positive
    private Integer id_book;

    @Positive
    private Integer quantity;
}
