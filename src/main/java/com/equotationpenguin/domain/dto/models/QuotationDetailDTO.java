package com.equotationpenguin.domain.dto.models;

import com.pinguinera.persistence.entity.Book;
import com.pinguinera.persistence.entity.Quotation;
import com.pinguinera.persistence.entity.QuotationPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuotationDetailDTO {

    private QuotationPK id;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private Quotation quotation;

    private Book book;
}
