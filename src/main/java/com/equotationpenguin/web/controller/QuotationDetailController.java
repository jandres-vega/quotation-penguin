package com.equotationpenguin.web.controller;

import com.pinguinera.domain.dto.request.QuotationRequestDTO;
import com.pinguinera.domain.service.quotation.QuotationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotation")
public class QuotationDetailController {

    private final QuotationService quotationService;

    public QuotationDetailController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping("/detail")
    public ResponseEntity<?> getQuotationCustomerDetail(@Valid @RequestBody QuotationRequestDTO quotationDetail){
        return new ResponseEntity<>(quotationService.QuotationDetailCalculation(quotationDetail), HttpStatus.CREATED);
    }
}
