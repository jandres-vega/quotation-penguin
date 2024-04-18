package com.equotationpenguin.persistence.converter.bookConverter;

import com.equotationpenguin.domain.dto.models.BookDTO;
import com.equotationpenguin.persistence.entity.Book;

import java.util.List;

public interface BookConverter {

    Book toBook(BookDTO bookDTO);
    BookDTO toBookDTO(Book book);
    List<Book> convertBookList(List<BookDTO> bookDtoList);
    List<BookDTO> ConvertBookList(List<Book> bookList);
}
