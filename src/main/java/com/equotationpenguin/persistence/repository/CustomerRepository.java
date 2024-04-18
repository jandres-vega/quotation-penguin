package com.equotationpenguin.persistence.repository;

import com.pinguinera.domain.dto.models.CustomerDTO;
import com.pinguinera.domain.repository.CustomerDtoRepository;
import com.pinguinera.persistence.crud.CustomerCrudRepository;
import com.pinguinera.persistence.entity.Customer;
import com.pinguinera.persistence.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository implements CustomerDtoRepository {

    private final CustomerCrudRepository customerCrudRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerRepository(CustomerCrudRepository customerCrudRepository, CustomerMapper customerMapper) {
        this.customerCrudRepository = customerCrudRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.getCustomerConverter().toCustomer(customerDTO);
        return customerMapper.getCustomerConverter().toCustomerDTO(customerCrudRepository.save(customer));
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = (List<Customer>) customerCrudRepository.findAll();
        return customers.stream()
                .map(custom -> customerMapper
                        .getCustomerConverter()
                        .toCustomerDTO(custom))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findCustomerByEmail(String email) {
        Customer customerFind = customerCrudRepository.getCustomerByEmail(email);
        if (customerFind == null) return null; {}
        return customerMapper.getCustomerConverter().toCustomerDTO(customerFind);
    }
}
