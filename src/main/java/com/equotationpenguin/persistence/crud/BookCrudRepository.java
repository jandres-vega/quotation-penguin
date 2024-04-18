package com.equotationpenguin.persistence.crud;

import com.equotationpenguin.persistence.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Integer> {

    Book getBookByTitle(String name);
}
