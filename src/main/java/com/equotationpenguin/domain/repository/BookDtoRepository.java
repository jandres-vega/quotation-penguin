package com.equotationpenguin.domain.repository;

import com.pinguinera.domain.dto.models.BookDTO;

import java.util.List;

public interface BookDtoRepository {

    BookDTO saveBook(BookDTO bookDTO);

    List<BookDTO> findAllBook();

    boolean isExistsBook(Integer idBook);
}
