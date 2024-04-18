package com.equotationpenguin.persistence.crud;

import com.pinguinera.persistence.entity.Quotation;
import org.springframework.data.repository.CrudRepository;

public interface QuoationCrudRepository extends CrudRepository<Quotation, Integer> {
}
