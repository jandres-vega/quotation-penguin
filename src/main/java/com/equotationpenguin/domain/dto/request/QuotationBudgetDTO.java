package com.equotationpenguin.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuotationBudgetDTO {

    private List<CopyRequest> copies;

    private float budget;

    private int seniority;
}
