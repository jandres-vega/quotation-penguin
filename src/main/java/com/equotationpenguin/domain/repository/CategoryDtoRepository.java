package com.equotationpenguin.domain.repository;

import com.equotationpenguin.domain.dto.models.CategoryDTO;

import java.util.List;

public interface CategoryDtoRepository {

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategory();

    CategoryDTO getCategoryById(int id);

    CategoryDTO getCategoryByName(String title);
}
