package com.equotationpenguin.persistence.crud;

import com.pinguinera.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {

    Customer getCustomerByEmail(String email);
}
