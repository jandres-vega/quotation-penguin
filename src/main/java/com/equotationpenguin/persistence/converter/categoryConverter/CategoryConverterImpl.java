package com.equotationpenguin.persistence.converter.categoryConverter;

import com.equotationpenguin.domain.dto.models.CategoryDTO;
import com.equotationpenguin.persistence.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverterImpl implements CategoryConverter{

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.getNameCategory()
        );
    }

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(
                category.getIdCategory(),
                category.getNameCategory()
        );
    }

    @Override
    public List<CategoryDTO> toCategoryDTOList(List<Category> categoryList) {
        return categoryList.stream()
                .map(this::toCategoryDTO)
                .collect(Collectors.toList());
    }
}
