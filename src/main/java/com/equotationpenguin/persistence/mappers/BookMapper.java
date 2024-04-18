package com.equotationpenguin.persistence.mappers;

import com.pinguinera.persistence.converter.bookConverter.BookConverter;
import com.pinguinera.persistence.converter.bookConverter.BookConverterImpl;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final BookConverter bookConverter;


    public BookMapper(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }


    public BookConverter getBookConverter(){
        if (bookConverter == null){
            return new BookConverterImpl();
        }
        return bookConverter;
    }

}
