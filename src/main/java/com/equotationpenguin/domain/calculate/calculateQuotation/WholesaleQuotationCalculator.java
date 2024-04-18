package com.equotationpenguin.domain.calculate.calculateQuotation;

import com.pinguinera.domain.calculate.calculateDiscountSeniority.CalculateDiscountSeniority;
import com.pinguinera.domain.dto.response.BookResponse;
import com.pinguinera.domain.dto.response.QuotationResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class WholesaleQuotationCalculator implements CalculateQuotation {

    private final CalculateDiscountSeniority calculateDiscountSeniority;

    public WholesaleQuotationCalculator(CalculateDiscountSeniority calculateDiscountSeniority) {
        this.calculateDiscountSeniority = calculateDiscountSeniority;
    }


    public List<BookResponse> copiesSort(List<BookResponse> copies){
        List<BookResponse> copyList = new ArrayList<>(copies);
        copyList.sort((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()));
        return copyList;
    }

    @Override
    public QuotationResponse calculateTotalPrice(List<BookResponse> copies, LocalDate customerSeniority) {
        double totalPriceCopies = 0;
        double discountAccomulated = 0;
        List<BookResponse> copyOrder = copiesSort(copies);
        for (BookResponse copy : copyOrder) {
            copy.setTotalPrice(copy.getPrice() * copy.getQuantity());
            totalPriceCopies += copy.getPrice();
        }
        double accumulatedDiscount = 0.0f;
        for (int i = 10; i < copyOrder.size(); i++) {
            BookResponse copy = copyOrder.get(i);
            double price = copy.getPrice();
            accumulatedDiscount += 0.15f;
            double discount = price * accumulatedDiscount;
            double discountedPrice = price - discount;
            discountAccomulated += discountedPrice;
            copy.setPrice(discountedPrice);
            totalPriceCopies += discountedPrice;
        }
        double totalDiscount = calculateDiscountSeniority.calculateDiscountV2(customerSeniority, (float) totalPriceCopies);
        double totalDiscountAccomulated = totalDiscount + discountAccomulated;
        double totalProcceDiscount = totalPriceCopies - totalDiscountAccomulated;
        return new QuotationResponse(copyOrder, totalProcceDiscount, totalDiscountAccomulated);
    }
}
