package com.equotationpenguin.domain.dto.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private Integer idCustomer;

    private String name;

    private String email;

    private String password;

    private LocalDate localDate;

    public CustomerDTO(Integer idCustomer, String name, String email, String password, LocalDate localDate) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.password = password;
        this.localDate = localDate;
    }
}
