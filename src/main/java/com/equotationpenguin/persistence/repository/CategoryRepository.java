package com.equotationpenguin.persistence.repository;

import com.equotationpenguin.domain.dto.models.CategoryDTO;
import com.equotationpenguin.domain.repository.CategoryDtoRepository;
import com.equotationpenguin.persistence.crud.CategoryCrudRepository;
import com.equotationpenguin.persistence.entity.Category;
import com.equotationpenguin.persistence.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements CategoryDtoRepository {

    private final CategoryCrudRepository categoryCrudRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryRepository(CategoryCrudRepository categoryCrudRepository, CategoryMapper categoryMapper) {
        this.categoryCrudRepository = categoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = (List<Category>) categoryCrudRepository.findAll();
        return categoryMapper.getCategoryConverter().toCategoryDTOList(categories);
    }

    @Override
    public CategoryDTO getCategoryById(int id) {
        Category category = categoryCrudRepository.findById(id).orElse(null);
        if (category == null) return null;
        return categoryMapper.getCategoryConverter().toCategoryDTO(category);
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryCrudRepository.findCategoryByNameCategory(name);
        if (category == null) return null;
        return categoryMapper.getCategoryConverter().toCategoryDTO(category);
    }
    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.getCategoryConverter().toCategory(categoryDTO);
        return categoryMapper.getCategoryConverter().toCategoryDTO(categoryCrudRepository.save(category));
    }
}
