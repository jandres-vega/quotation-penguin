package com.equotationpenguin.web.controller;

import com.pinguinera.domain.dto.request.QuotationBudgetDTO;
import com.pinguinera.domain.service.quotation.QuotationBudgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotation")
public class QuotationBudgetController {

    private final QuotationBudgeService quotationBudgeService;

    public QuotationBudgetController(QuotationBudgeService quotationBudgeService) {
        this.quotationBudgeService = quotationBudgeService;
    }

    @PostMapping("/budget")
    public ResponseEntity<?> calculateQuotationBudget(@RequestBody QuotationBudgetDTO quotationBudgetDTO){
        System.out.println("holaaaaaaaaaaaaaaaaaaaaa");
        return new ResponseEntity<>(quotationBudgeService.calculateQuotaionBudget(quotationBudgetDTO), HttpStatus.CREATED);
    }
}
