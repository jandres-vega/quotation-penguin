package com.equotationpenguin.domain.calculate.calculateQuotation;

import com.equotationpenguin.domain.dto.response.BookResponse;
import com.equotationpenguin.domain.dto.response.QuotationResponse;

import java.time.LocalDate;
import java.util.List;

public interface CalculateQuotation {

    QuotationResponse calculateTotalPrice(List<BookResponse> copies, LocalDate customerSeniority);
}
