package com.equotationpenguin.domain.calculate.calculateQuotation;

import com.pinguinera.domain.calculate.calculateDiscountSeniority.CalculateDiscountSeniority;
import com.pinguinera.domain.dto.response.BookResponse;
import com.pinguinera.domain.dto.response.QuotationResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RetailQuotationCalculator implements CalculateQuotation{

    private final CalculateDiscountSeniority calculateDiscountSeniority;

    public RetailQuotationCalculator(CalculateDiscountSeniority calculateDiscountSeniority) {
        this.calculateDiscountSeniority = calculateDiscountSeniority;
    }

    @Override
    public QuotationResponse calculateTotalPrice(List<BookResponse> quotations, LocalDate seniority) {
        float totalPriceCopies = 0;

        for (BookResponse bookResponse : quotations) {
            double totalIncrement = (bookResponse.getPrice() * 0.02);
            bookResponse.setPrice(bookResponse.getPrice() + totalIncrement);
            bookResponse.setTotalPrice(bookResponse.getPrice() * bookResponse.getQuantity());
            totalPriceCopies += bookResponse.getTotalPrice();
        }
        double totalDiscount = calculateDiscountSeniority.calculateDiscountV2(seniority, totalPriceCopies);
        double discountSeniority = totalPriceCopies - totalDiscount;

        return new QuotationResponse(quotations, totalPriceCopies, totalDiscount == 0.0 ? 0 : discountSeniority);
    }
}
