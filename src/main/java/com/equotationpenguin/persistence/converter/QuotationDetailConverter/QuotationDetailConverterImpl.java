package com.equotationpenguin.persistence.converter.QuotationDetailConverter;

import com.pinguinera.domain.dto.models.QuotationDetailDTO;
import com.pinguinera.persistence.entity.QuotationDetail;
import org.springframework.stereotype.Component;

@Component
public class QuotationDetailConverterImpl implements QuotationDetailConverter {
    @Override
    public QuotationDetail toQuotationDetail(QuotationDetailDTO quotationDetailDTO) {
        return new QuotationDetail(
                quotationDetailDTO.getId(),
                quotationDetailDTO.getQuantity(),
                quotationDetailDTO.getUnitPrice(),
                quotationDetailDTO.getTotalPrice(),
                quotationDetailDTO.getQuotation(),
                quotationDetailDTO.getBook()
        );
    }

    @Override
    public QuotationDetailDTO toQuotationDetailDTO(QuotationDetail quotationDetail) {
        return new QuotationDetailDTO(
                quotationDetail.getId(),
                quotationDetail.getQuantity(),
                quotationDetail.getUnitPrice(),
                quotationDetail.getTotalPrice(),
                quotationDetail.getQuotation(),
                quotationDetail.getBook()
        );
    }
}
