package com.equotationpenguin.domain.calculate.filterBooks;

import com.equotationpenguin.domain.dto.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class FilterBooks {

    public BookResponse findCheapestNovel(List<BookResponse> copies) {
        return copies.stream()
                .filter(copy -> copy.getCategory().getIdCategory() == 2)
                .min(Comparator.comparingDouble(BookResponse::getPrice))
                .orElse(null);
    }

    public BookResponse findCheapestBook(List<BookResponse> copies) {
        return copies.stream()
                .filter(copy -> copy.getCategory().getIdCategory() == 1)
                .min(Comparator.comparingDouble(BookResponse::getPrice))
                .orElse(null);
    }

    private BookResponse  getCheapestCopy(BookResponse copy1, BookResponse  copy2) {
        return copy1.getPrice() < copy2.getPrice() ? copy1 : copy2;
    }

    public BookResponse findCheapestCopy(BookResponse  cheapestNovel, BookResponse  cheapestBook) {
        return getCheapestCopy(cheapestNovel, cheapestBook);
    }
}
