package com.equotationpenguin.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Quotation> questions;

    @Column(name = "created_date")
    @JsonIgnore
    @CreatedDate
    private LocalDate createdDate;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
