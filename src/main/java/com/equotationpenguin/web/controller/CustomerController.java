package com.equotationpenguin.web.controller;


import com.pinguinera.domain.dto.models.CustomerDTO;
import com.pinguinera.domain.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/register")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.registerUser(customerDTO), HttpStatus.CREATED);
    }
}
