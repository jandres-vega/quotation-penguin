package com.equotationpenguin.domain.service.customer;

import com.pinguinera.domain.dto.models.CustomerDTO;
import com.pinguinera.exceptions.ResourceNotFoundException;
import com.pinguinera.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerDTO registerUser(CustomerDTO customerDTO) {

        CustomerDTO customerFind = customerRepository.findCustomerByEmail(customerDTO.getEmail());
        if (customerFind != null) {
            throw new ResourceNotFoundException("El usuario ya se encuentra registrado", "email", customerDTO.getEmail(), HttpStatus.CONFLICT);
        }
        String passwordHash = passwordEncoder.encode(customerDTO.getPassword());
        customerDTO.setPassword(passwordHash);
        return customerRepository.registerCustomer(customerDTO);
    }


}
