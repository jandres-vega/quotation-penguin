package com.equotationpenguin.domain.service.quotation;

import com.equotationpenguin.domain.calculate.calculateQuotation.RetailQuotationCalculator;
import com.equotationpenguin.domain.calculate.calculateQuotation.WholesaleQuotationCalculator;
import com.equotationpenguin.domain.dto.models.CustomerDTO;
import com.equotationpenguin.domain.dto.request.QuotationRequestDTO;
import com.equotationpenguin.domain.dto.response.BookResponse;
import com.equotationpenguin.domain.dto.response.QuotationResponse;
import com.equotationpenguin.domain.service.book.BookService;
import com.equotationpenguin.persistence.repository.CustomerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private final BookService bookService;
    private final RetailQuotationCalculator retailQuotationCalculator;
    private final WholesaleQuotationCalculator wholesaleQuotationCalculator;
    private final CustomerRepository customerRepository;

    public QuotationService(BookService bookService, RetailQuotationCalculator retailQuotationCalculator, WholesaleQuotationCalculator wholesaleQuotationCalculator, CustomerRepository customerRepository) {
        this.bookService = bookService;
        this.retailQuotationCalculator = retailQuotationCalculator;
        this.wholesaleQuotationCalculator = wholesaleQuotationCalculator;
        this.customerRepository = customerRepository;
    }

    public QuotationResponse QuotationDetailCalculation(QuotationRequestDTO quotationRequestDTO){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerDTO customer = customerRepository.findCustomerByEmail((String) authentication.getPrincipal());
        System.out.println(customer.getLocalDate());
        List<BookResponse> bookResponseList = bookService.findBooksOfQuotation(quotationRequestDTO.getCopies());
        if(!isWholesalePurchase(bookResponseList)){
            return retailQuotationCalculator.calculateTotalPrice(bookResponseList, customer.getLocalDate());
        }else {
            return wholesaleQuotationCalculator.calculateTotalPrice(bookResponseList, customer.getLocalDate());
        }
    }

    public boolean isWholesalePurchase(List<BookResponse> quotationList) {
        int totalQuantity = quotationList.stream()
                .mapToInt(BookResponse::getQuantity).sum();
        return totalQuantity > 10;
    }
}
