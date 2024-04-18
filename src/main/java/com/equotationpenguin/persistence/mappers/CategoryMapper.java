package com.equotationpenguin.persistence.mappers;

import com.pinguinera.persistence.converter.categoryConverter.CategoryConverter;
import com.pinguinera.persistence.converter.categoryConverter.CategoryConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    private final CategoryConverter categoryConverter;

    public CategoryMapper(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    public CategoryConverter getCategoryConverter() {
        if (categoryConverter == null){
            return new CategoryConverterImpl();
        }
        return categoryConverter;
    }

}
