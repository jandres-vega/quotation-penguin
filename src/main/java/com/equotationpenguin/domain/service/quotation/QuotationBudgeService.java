package com.equotationpenguin.domain.service.quotation;

import com.equotationpenguin.domain.calculate.calculateBudget.CalculateBudgetQuotation;
import com.equotationpenguin.domain.dto.request.QuotationBudgetDTO;
import com.equotationpenguin.domain.dto.response.BookResponse;
import com.equotationpenguin.domain.dto.response.QuotationBudgetResponse;
import com.equotationpenguin.domain.service.book.BookService;
import com.equotationpenguin.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationBudgeService {

    private final BookService bookService;
    private final CalculateBudgetQuotation calculateBudgetQuotation;

    public QuotationBudgeService(BookService bookService, CalculateBudgetQuotation calculateBudgetQuotation) {
        this.bookService = bookService;
        this.calculateBudgetQuotation = calculateBudgetQuotation;
    }

    public QuotationBudgetResponse calculateQuotaionBudget(QuotationBudgetDTO quotationBudgetDTO) {
        List<BookResponse> bookResponseList = bookService.findBooksOfQuotation(quotationBudgetDTO.getCopies());
        this.validateWholesalePurchase(bookResponseList);
        return calculateBudgetQuotation.createCalculateQuotationBudget(bookResponseList, quotationBudgetDTO.getBudget(), quotationBudgetDTO.getSeniority());
    }

    public void validateWholesalePurchase(List<BookResponse> optimalCopies) {
        if (optimalCopies.size() < 10) {
            throw new ResourceNotFoundException("NO puedes hacer compras al por mayor", "", "", HttpStatus.CONFLICT);
        }
    }

}
