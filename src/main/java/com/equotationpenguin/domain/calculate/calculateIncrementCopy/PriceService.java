package com.equotationpenguin.domain.calculate.calculateIncrementCopy;

import com.pinguinera.domain.dto.models.BookDTO;
import com.pinguinera.domain.dto.models.CategoryDTO;
import com.pinguinera.domain.service.category.CategoryService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PriceService {

    private final Map<String, PriceCalculateStrategy> strategy;
    private final CategoryService categoryService;

    public PriceService(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.strategy = new HashMap<>();
        strategy.put("Book", new BookCalculatePriceStrategy());
        strategy.put("Novel", new NovelCalculatePriceStrategy());
    }


    public BookDTO calculateBookPrice(BookDTO bookDTO){
        CategoryDTO category = categoryService.getCategoryById(bookDTO.getIdCategory());
        String categoryFind = category.getNameCategory();
        PriceCalculateStrategy strategy = this.strategy.get(categoryFind);
        double incrementBook = strategy.calculatePriceBook(bookDTO.getPrice());
        bookDTO.setPrice(incrementBook);
        return bookDTO;
    }
}
