package com.equotationpenguin.domain.dto.response;

import com.equotationpenguin.persistence.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Integer idBook;

    private String title;

    private String author;

    private int publicationYear;

    private Double price;

    private Category category;

    private Integer quantity;
    private Double totalPrice;

    public BookResponse(Integer idBook, String title, String author, int publicationYear, Double price, Category category, Integer quantity) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }


    public BookResponse(Integer idBook, String title, double price, Category category) {
        this.idBook = idBook;
        this.title = title;
        this.price = price;
        this.category = category;
    }
}
