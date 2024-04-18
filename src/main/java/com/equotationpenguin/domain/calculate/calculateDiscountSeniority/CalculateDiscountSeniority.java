package com.equotationpenguin.domain.calculate.calculateDiscountSeniority;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;


@Component
public class CalculateDiscountSeniority {

    public float calculateDiscount(int customerSeniority, float totalPrice) {
        float discountRate = customerSeniority == 0 ? 0.0f : (customerSeniority <= 2 ? 0.12f : 0.17f);
        return discountRate * totalPrice;
    }
    public float calculateDiscountV2(LocalDate customerCreatedDate, float totalPrice) {
        int customerSeniority = calculateSeniority(customerCreatedDate);
        System.out.println(customerSeniority);
        float discountRate = getDiscountRate(customerSeniority);
        return discountRate * totalPrice;
    }

    private int calculateSeniority(LocalDate customerCreatedDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(customerCreatedDate, currentDate);
        return Math.min(period.getYears(), 2);
    }

    private float getDiscountRate(int customerSeniority) {
        return customerSeniority == 0 ? 0.0f : (customerSeniority == 1 ? 0.12f : 0.17f);
    }

}
