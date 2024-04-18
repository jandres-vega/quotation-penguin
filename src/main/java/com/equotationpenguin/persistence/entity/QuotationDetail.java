package com.equotationpenguin.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "quotation_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuotationDetail {

    @EmbeddedId
    private QuotationPK id;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    @ManyToOne
    @MapsId("idQuotation")
    @JoinColumn(name = "id_quotation", insertable = false, updatable = false)
    private Quotation quotation;

    @ManyToOne
    @JoinColumn(name = "id_book", insertable = false, updatable = false)
    private Book book;
}
