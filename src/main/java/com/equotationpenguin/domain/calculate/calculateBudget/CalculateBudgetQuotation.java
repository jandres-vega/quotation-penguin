package com.equotationpenguin.domain.calculate.calculateBudget;

import com.equotationpenguin.domain.calculate.calculateDiscountSeniority.CalculateDiscountSeniority;
import com.equotationpenguin.domain.calculate.filterBooks.FilterBooks;
import com.equotationpenguin.domain.dto.response.BookResponse;
import com.equotationpenguin.domain.dto.response.QuotationBudgetResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculateBudgetQuotation {

    private final FilterBooks filterBooks;
    private final CalculateDiscountSeniority calculateDiscountSeniority;

    public CalculateBudgetQuotation(FilterBooks filterBooks, CalculateDiscountSeniority calculateDiscountSeniority) {
        this.filterBooks = filterBooks;
        this.calculateDiscountSeniority = calculateDiscountSeniority;
    }

    public QuotationBudgetResponse createCalculateQuotationBudget(List<BookResponse> copies, float budget, int seniority){
        BookResponse cheapestNovel = filterBooks.findCheapestNovel(copies);
        BookResponse cheapestBook = filterBooks.findCheapestBook(copies);
        BookResponse copyMin = filterBooks.findCheapestCopy(cheapestNovel, cheapestBook);
        List<BookResponse> optimalCopies = new ArrayList<>();
        optimalCopies.add(copyMin);
        if (budget >= copyMin.getPrice()){
            budget -= copyMin.getPrice();
        }
        return addRemainingCopiesToOptimalList(optimalCopies, copyMin, budget, seniority);
    }

    private QuotationBudgetResponse addRemainingCopiesToOptimalList(List<BookResponse> optimalCopies, BookResponse copy, double budget, int custom){
        double discountIncrement = 0.15f;
        double discountAccumulate = 0.0f;
        while (budget >= copy.getPrice()){
            float discountMayor;
            double newPrice = copy.getPrice();
            if (optimalCopies.size() > 9) {
                discountAccumulate += discountIncrement;
                discountMayor = (float) (copy.getPrice() * discountAccumulate);
                newPrice = copy.getPrice() - discountMayor;
                if (newPrice < 0)break;
                addCopyToList(optimalCopies, copy, (float) newPrice);
                budget -= newPrice;
            }else {
                addCopyToList(optimalCopies, copy, (float) newPrice);
                budget -= newPrice;
            }
        }
        Map<String, Float> totals = calculatePurchaseTotalWithDiscount(optimalCopies, custom);
        return new QuotationBudgetResponse(optimalCopies, optimalCopies.size() - 1, 1, totals.get("totalPurchase"), totals.get("totalWithDiscount"));
    }

    private Map<String, Float > calculatePurchaseTotalWithDiscount(List<BookResponse> copies, int custom){
        float totalPurchase = 0f;
        Map<String, Float> totals = new HashMap<>();
        for (BookResponse priceTotal: copies){
            totalPurchase += priceTotal.getPrice();
        }
        float discountTotal = calculateDiscountSeniority.calculateDiscount(custom, totalPurchase);
        totals.put("totalPurchase", totalPurchase);
        totals.put("totalWithDiscount", discountTotal);
        return totals;
    }

    private void addCopyToList(List<BookResponse> optimalCopies, BookResponse copy, float newPrice) {
        BookResponse newCopy = new BookResponse(
                copy.getIdBook(),
                copy.getTitle(),
                newPrice,
                copy.getCategory());
        optimalCopies.add(newCopy);
    }
}
