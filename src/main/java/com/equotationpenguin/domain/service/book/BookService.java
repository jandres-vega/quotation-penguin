package com.equotationpenguin.domain.service.book;

import com.equotationpenguin.domain.calculate.calculateIncrementCopy.PriceService;
import com.equotationpenguin.domain.dto.models.BookDTO;
import com.equotationpenguin.domain.dto.request.CopyRequest;
import com.equotationpenguin.domain.dto.response.BookResponse;
import com.equotationpenguin.exceptions.ResourceNotFoundException;
import com.equotationpenguin.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PriceService priceService;

    @Autowired
    public BookService(BookRepository bookRepository, PriceService priceService) {
        this.bookRepository = bookRepository;
        this.priceService = priceService;
    }

    public List<BookDTO> findAll(){
        return bookRepository.findAllBook();
    }
    public boolean validateCopy(int id){
        return bookRepository.isExistsBook(id);
    }

    public BookDTO saveBook(BookDTO bookDTO){
        BookDTO bookFind = bookRepository.getBookByTitle(bookDTO.getTitle());
        if(bookFind != null){
            throw new ResourceNotFoundException("the book is already registered ", "title", bookDTO.getTitle(), HttpStatus.CONFLICT);
        }
        BookDTO newBookDTO = priceService.calculateBookPrice(bookDTO);
        return bookRepository.saveBook(newBookDTO);
    }

    public List<BookResponse> findBooksOfQuotation(List<CopyRequest> copies){
        List<BookDTO> bookDTOS = this.findAll();
        List<BookResponse> copiesNew = new ArrayList<>();
        for (CopyRequest copyRequest : copies) {
            if (!validateCopy(copyRequest.getId_book())){
                throw new ResourceNotFoundException("the book is not registered ", "title", copyRequest.getId_book(), HttpStatus.NOT_FOUND);
            }
            BookDTO bookFind = bookDTOS.stream().filter(book -> book.getIdBook()
                    .equals(copyRequest.getId_book()))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("the book is not registered ", "title", copyRequest.getId_book(), HttpStatus.NOT_FOUND));

            copiesNew.add(new BookResponse(
                    bookFind.getIdBook(),
                    bookFind.getTitle(),
                    bookFind.getAuthor(),
                    bookFind.getPublicationYear(),
                    bookFind.getPrice(),
                    bookFind.getCategory(),
                    copyRequest.getQuantity()
            ));
        }
        return copiesNew;
    }
}
