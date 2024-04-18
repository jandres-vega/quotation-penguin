package com.equotationpenguin.domain.repository;

import com.equotationpenguin.domain.dto.models.QuotationDTO;

import java.util.List;

public interface QuotationDtoRepository {

    QuotationDTO registerQuoationDto(QuotationDTO quotationDTO);

    List<QuotationDTO> findAllQuotationDto();
}
