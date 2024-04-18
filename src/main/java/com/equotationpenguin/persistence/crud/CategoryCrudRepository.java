package com.equotationpenguin.persistence.crud;

import com.pinguinera.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    Category findCategoryByNameCategory(String name);
}
