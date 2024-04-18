package com.equotationpenguin.persistence.converter.QuotationDetailConverter;

import com.equotationpenguin.domain.dto.models.QuotationDetailDTO;
import com.equotationpenguin.persistence.entity.QuotationDetail;
import org.springframework.stereotype.Component;

@Component
public interface QuotationDetailConverter {

    QuotationDetail toQuotationDetail(QuotationDetailDTO quotationDetailDTO);
    QuotationDetailDTO toQuotationDetailDTO(QuotationDetail quotationDetail);

}
