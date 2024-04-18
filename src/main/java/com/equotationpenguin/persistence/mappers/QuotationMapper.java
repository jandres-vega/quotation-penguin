package com.equotationpenguin.persistence.mappers;

import com.equotationpenguin.persistence.converter.quotationConverter.QuotationConverter;
import com.equotationpenguin.persistence.converter.quotationConverter.QuotationConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotationMapper {

    private final QuotationConverter quotationConverter;

    @Autowired
    public QuotationMapper(QuotationConverter quotationConverter) {
        this.quotationConverter = quotationConverter;
    }

    public QuotationConverter getQuotationConverter(){
        if (quotationConverter == null){
            return new QuotationConverterImpl();
        }
        return quotationConverter;
    }
}
