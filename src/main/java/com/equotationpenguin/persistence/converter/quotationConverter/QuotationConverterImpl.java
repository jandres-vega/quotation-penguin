package com.equotationpenguin.persistence.converter.quotationConverter;

import com.pinguinera.domain.dto.models.QuotationDTO;
import com.pinguinera.persistence.entity.Quotation;
import org.springframework.stereotype.Component;

@Component
public class QuotationConverterImpl implements QuotationConverter {
    @Override
    public Quotation toQuotation(QuotationDTO quotationDTO) {
        return new Quotation(
                quotationDTO.getIdQuotation(),
                quotationDTO.getIdCustomer(),
                quotationDTO.getDateQuotation(),
                quotationDTO.getTotal(),
                quotationDTO.getDiscount(),
                quotationDTO.getCustomer(),
                quotationDTO.getOrderItems()
        );
    }

    @Override
    public QuotationDTO toQuotationDTO(Quotation quotation) {
        return new QuotationDTO(
                quotation.getIdQuotation(),
                quotation.getIdCustomer(),
                quotation.getDateQuotation(),
                quotation.getTotal(),
                quotation.getDiscount(),
                quotation.getCustomer(),
                quotation.getOrderItems()
        );
    }
}
