package com.equotationpenguin.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quotations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quotation")
    private Integer idQuotation;

    @Column(name = "id_customer")
    private Integer idCustomer;

    @Column(name = "date_quotation")
    private LocalDateTime dateQuotation;

    private Double total;

    private Double discount;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "quotation", cascade = {CascadeType.ALL})
    private List<QuotationDetail> orderItems;
}
