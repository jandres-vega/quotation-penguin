package com.equotationpenguin.persistence.repository;

import com.pinguinera.domain.dto.models.QuotationDTO;
import com.pinguinera.domain.repository.QuotationDtoRepository;
import com.pinguinera.persistence.crud.QuoationCrudRepository;
import com.pinguinera.persistence.entity.Quotation;
import com.pinguinera.persistence.mappers.QuotationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class QuotationRepository implements QuotationDtoRepository {

    private final QuoationCrudRepository quotationCrudRepository;
    private final QuotationMapper quotationMapper;

    public QuotationRepository(QuoationCrudRepository quotationCrudRepository, QuotationMapper quotationMapper) {
        this.quotationCrudRepository = quotationCrudRepository;
        this.quotationMapper = quotationMapper;
    }

    @Override
    public QuotationDTO registerQuoationDto(QuotationDTO quotationDTO) {
        Quotation quotation = quotationMapper.getQuotationConverter().toQuotation(quotationDTO);
        return quotationMapper.getQuotationConverter().toQuotationDTO(quotationCrudRepository.save(quotation));
    }

    @Override
    public List<QuotationDTO> findAllQuotationDto() {
        List<Quotation> quotations = (List<Quotation>) quotationCrudRepository.findAll();
        return quotations.stream().map(q -> quotationMapper
                .getQuotationConverter()
                .toQuotationDTO(q)).
                collect(Collectors.toList());
    }
}
