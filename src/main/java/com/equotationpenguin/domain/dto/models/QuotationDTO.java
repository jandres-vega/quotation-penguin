package com.equotationpenguin.domain.dto.models;

import com.pinguinera.persistence.entity.Customer;
import com.pinguinera.persistence.entity.QuotationDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuotationDTO {

    private Integer idQuotation;

    private Integer idCustomer;

    private LocalDateTime dateQuotation;

    private Double total;

    private Double discount;

    private Customer customer;

    private List<QuotationDetail> orderItems;
}
