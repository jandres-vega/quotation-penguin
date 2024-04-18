package com.equotationpenguin.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuotationResponse {

    private List<BookResponse> orderItems;

    private double totalQuotation;

    private double discountTotal;
}
