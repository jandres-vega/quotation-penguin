package com.equotationpenguin.domain.service;

import com.equotationpenguin.domain.dto.models.CustomerDTO;
import com.equotationpenguin.persistence.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public UserSecurityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        CustomerDTO userEntity = customerRepository.findCustomerByEmail(email);
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles("CUSTOMER")
                .build();
    }
}
