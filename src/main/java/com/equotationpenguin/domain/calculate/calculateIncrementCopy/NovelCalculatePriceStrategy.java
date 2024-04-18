package com.equotationpenguin.domain.calculate.calculateIncrementCopy;

public class NovelCalculatePriceStrategy implements PriceCalculateStrategy {
    @Override
    public double calculatePriceBook(double priceOriginal) {
        return priceOriginal * 2;
    }
}
