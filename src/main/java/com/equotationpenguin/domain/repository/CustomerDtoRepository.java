package com.equotationpenguin.domain.repository;

import com.pinguinera.domain.dto.models.CustomerDTO;

import java.util.List;

public interface CustomerDtoRepository {

    CustomerDTO registerCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> findAllCustomers();

    CustomerDTO findCustomerByEmail(String email);
}
