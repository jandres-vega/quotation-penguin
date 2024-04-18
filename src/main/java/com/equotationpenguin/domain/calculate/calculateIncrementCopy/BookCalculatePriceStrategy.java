package com.equotationpenguin.domain.calculate.calculateIncrementCopy;

public class BookCalculatePriceStrategy implements PriceCalculateStrategy {
    @Override
    public double calculatePriceBook(double priceOriginal) {
        return priceOriginal * (1 + 1.0 / 3.0);
    }
}
