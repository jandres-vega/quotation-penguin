package com.equotationpenguin.persistence.converter.customerConverter;

import com.pinguinera.domain.dto.models.CustomerDTO;
import com.pinguinera.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverterImpl implements CustomerConverter {
    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getPassword()

        );
    }

    @Override
    public CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getIdCustomer(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword()
        );
    }
}
