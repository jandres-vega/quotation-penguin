package com.equotationpenguin.domain.service.category;

import com.pinguinera.domain.dto.models.CategoryDTO;
import com.pinguinera.exceptions.ResourceNotFoundException;
import com.pinguinera.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.getAllCategory();
    }

    public CategoryDTO getCategoryById(int id){
        CategoryDTO categoryFind = categoryRepository.getCategoryById(id);
        if (categoryFind == null) {
            throw  new ResourceNotFoundException("category not found", "id", id, HttpStatus.NOT_FOUND);
        }else return categoryFind;
    }

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        CategoryDTO categoryFind = categoryRepository.getCategoryByName(categoryDTO.getNameCategory());
        if (categoryFind != null) {
            throw  new ResourceNotFoundException("Ya existe una categoria con ese nombre", "name", categoryDTO.getNameCategory(), HttpStatus.CONFLICT);
        }
        return categoryRepository.saveCategory(categoryDTO);
    }
}
