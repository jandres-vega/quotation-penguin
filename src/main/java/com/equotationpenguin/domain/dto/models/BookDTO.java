package com.equotationpenguin.domain.dto.models;
import com.pinguinera.persistence.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    private Integer idBook;

    private String title;

    private int idCategory;

    private String author;

    private int stock;

    private int publicationYear;

    private Double price;

    private Category category;

    public BookDTO(Integer idBook, String title, int idCategory, String author, int stock, int publicationYear, Double price, Category category) {
        this.idBook = idBook;
        this.title = title;
        this.idCategory = idCategory;
        this.author = author;
        this.stock = stock;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }
}
