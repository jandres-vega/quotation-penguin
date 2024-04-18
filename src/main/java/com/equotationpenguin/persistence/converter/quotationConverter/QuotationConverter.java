package com.equotationpenguin.persistence.converter.quotationConverter;

import com.pinguinera.domain.dto.models.QuotationDTO;
import com.pinguinera.persistence.entity.Quotation;
import org.springframework.stereotype.Component;

@Component
public interface QuotationConverter {

    Quotation toQuotation(QuotationDTO quotationDTO);
    QuotationDTO toQuotationDTO(Quotation quotation);
}
