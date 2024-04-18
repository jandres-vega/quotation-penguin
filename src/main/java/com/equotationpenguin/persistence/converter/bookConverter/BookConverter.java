package com.equotationpenguin.persistence.converter.bookConverter;

import com.pinguinera.domain.dto.models.BookDTO;
import com.pinguinera.persistence.entity.Book;

import java.util.List;

public interface BookConverter {

    Book toBook(BookDTO bookDTO);
    BookDTO toBookDTO(Book book);
    List<Book> convertBookList(List<BookDTO> bookDtoList);
    List<BookDTO> ConvertBookList(List<Book> bookList);
}
