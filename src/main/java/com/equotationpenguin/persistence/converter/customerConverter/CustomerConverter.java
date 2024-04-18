package com.equotationpenguin.persistence.converter.customerConverter;

import com.pinguinera.domain.dto.models.CustomerDTO;
import com.pinguinera.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerConverter {

    Customer toCustomer(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(Customer customer);
}
