package com.equotationpenguin.persistence.converter.QuotationDetailConverter;

import com.pinguinera.domain.dto.models.QuotationDetailDTO;
import com.pinguinera.persistence.entity.QuotationDetail;
import org.springframework.stereotype.Component;

@Component
public interface QuotationDetailConverter {

    QuotationDetail toQuotationDetail(QuotationDetailDTO quotationDetailDTO);
    QuotationDetailDTO toQuotationDetailDTO(QuotationDetail quotationDetail);

}
