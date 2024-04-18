package com.equotationpenguin.persistence.mappers;

import com.pinguinera.persistence.converter.customerConverter.CustomerConverter;
import com.pinguinera.persistence.converter.customerConverter.CustomerConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerMapper(CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }

    public CustomerConverter getCustomerConverter() {
        if (customerConverter == null){
            return new CustomerConverterImpl();
        }
        return customerConverter;
    }
}

