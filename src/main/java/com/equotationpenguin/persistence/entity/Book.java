package com.equotationpenguin.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;

    @Column(name = "id_category")
    private Integer idCategory;

    private String title;

    private String author;

    private Integer stock;

    @Column(name = "publication_year")
    private Integer publicationYear;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    public Book(Integer idBook, Integer idCategory, String title, String author, Integer stock, Integer publicationYear, Double price, Category category) {
        this.idBook = idBook;
        this.idCategory = idCategory;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

}
