package com.equotationpenguin.persistence.converter.bookConverter;

import com.equotationpenguin.domain.dto.models.BookDTO;
import com.equotationpenguin.persistence.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookConverterImpl implements BookConverter {
    @Override
    public Book toBook(BookDTO bookDTO) {
        return new Book(
                bookDTO.getIdBook(),
                bookDTO.getIdCategory(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getStock(),
                bookDTO.getPublicationYear(),
                bookDTO.getPrice(),
                bookDTO.getCategory()
        );
    }

    @Override
    public BookDTO toBookDTO(Book book) {
        return new BookDTO(
                book.getIdBook(),
                book.getTitle(),
                book.getIdCategory(),
                book.getAuthor(),
                book.getStock(),
                book.getPublicationYear(),
                book.getPrice(),
                book.getCategory()
        );
    }

    @Override
    public List<Book> convertBookList(List<BookDTO> bookDtoList) {
        return bookDtoList.stream()
                .map(this::toBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> ConvertBookList(List<Book> bookList) {
        return bookList.stream()
                .map(this::toBookDTO)
                .collect(Collectors.toList());
    }
}
