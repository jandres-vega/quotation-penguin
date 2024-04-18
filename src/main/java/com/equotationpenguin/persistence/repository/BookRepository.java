package com.equotationpenguin.persistence.repository;

import com.equotationpenguin.domain.dto.models.BookDTO;
import com.equotationpenguin.domain.repository.BookDtoRepository;
import com.equotationpenguin.persistence.crud.BookCrudRepository;
import com.equotationpenguin.persistence.entity.Book;
import com.equotationpenguin.persistence.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements BookDtoRepository {

    private final BookCrudRepository bookCrudRepository;

    private final BookMapper bookMapper;

    @Autowired
    public BookRepository(BookCrudRepository bookCrudRepository, BookMapper bookMapper) {
        this.bookCrudRepository = bookCrudRepository;
        this.bookMapper = bookMapper;
    }

    public BookDTO getBookByTitle(String title){
        Book bookFindTitle = bookCrudRepository.getBookByTitle(title);
        if (bookFindTitle == null)return null;
        return bookMapper.getBookConverter().toBookDTO(bookFindTitle);
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.getBookConverter().toBook(bookDTO);
        return bookMapper
                .getBookConverter()
                .toBookDTO(bookCrudRepository.save(book));
    }

    @Override
    public List<BookDTO> findAllBook() {
        List<Book> books = (List<Book>) bookCrudRepository.findAll();
        return bookMapper.getBookConverter().ConvertBookList(books);
    }

    @Override
    public boolean isExistsBook(Integer idBook) {
        return bookCrudRepository.existsById(idBook);
    }
}
