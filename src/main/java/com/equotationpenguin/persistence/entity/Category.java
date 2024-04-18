package com.equotationpenguin.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "categories")
@Setter
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
