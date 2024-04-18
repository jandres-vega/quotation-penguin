package com.equotationpenguin.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuotationBudgetResponse {

    private List<BookResponse> copies;
    private Integer quantityBooks;
    private Integer quantityNovels;
    private Float priceTotalCopiesDiscount;
    private Float totalPurchase;
}
