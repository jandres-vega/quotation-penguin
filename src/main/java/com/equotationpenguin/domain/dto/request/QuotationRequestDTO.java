package com.equotationpenguin.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuotationRequestDTO {

    @NotEmpty
    @NotNull
    private List<CopyRequest> copies;

    @NotNull
    private Integer customerSeniority;
}
