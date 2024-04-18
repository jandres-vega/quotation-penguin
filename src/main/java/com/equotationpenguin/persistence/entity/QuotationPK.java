package com.equotationpenguin.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class QuotationPK {

    @Column(name = "id_quotation")
    private Integer idQuotation;

    @Column(name = "id_book")
    private Integer idBook;
}
