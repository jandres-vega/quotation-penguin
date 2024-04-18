package com.equotationpenguin.persistence.converter.categoryConverter;

import com.pinguinera.domain.dto.models.CategoryDTO;
import com.pinguinera.persistence.entity.Category;

import java.util.List;

public interface CategoryConverter {

    Category toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTO(Category category);

    List<CategoryDTO> toCategoryDTOList(List<Category> categoryList);
}
