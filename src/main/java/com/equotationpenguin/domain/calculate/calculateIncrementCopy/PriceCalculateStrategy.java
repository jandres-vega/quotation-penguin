package com.equotationpenguin.domain.calculate.calculateIncrementCopy;

import org.springframework.stereotype.Component;

@Component
public interface PriceCalculateStrategy {

    double calculatePriceBook(double priceOriginal);
}
