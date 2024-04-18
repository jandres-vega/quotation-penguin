package com.equotationpenguin.persistence.converter.quotationConverter;

import com.equotationpenguin.domain.dto.models.QuotationDTO;
import com.equotationpenguin.persistence.entity.Quotation;
import org.springframework.stereotype.Component;

@Component
public interface QuotationConverter {

    Quotation toQuotation(QuotationDTO quotationDTO);
    QuotationDTO toQuotationDTO(Quotation quotation);
}
