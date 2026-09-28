package com.lsp.pricingservice.infrastructure.out.persistence.jpa.mapper;

import com.lsp.pricingservice.domain.model.Price;
import com.lsp.pricingservice.infrastructure.out.persistence.jpa.entity.PriceEntity;
import com.lsp.pricingservice.support.PriceTestDataFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceEntityMapperTest {

    private final PriceEntityMapper mapper = new PriceEntityMapperImpl();

    @Test
    void givenEntity_whenToDomain_thenMapAllFields() {
        PriceEntity entity = PriceTestDataFactory.priceEntity();

        Price result = mapper.toDomain(entity);

        assertThat(result).extracting(
                Price::getBrandId,
                Price::getProductId,
                Price::getStartDate,
                Price::getEndDate,
                Price::getPriceList,
                Price::getPriority,
                Price::getPrice,
                Price::getCurrencyIsoCode
        ).containsExactly(
                entity.getBrandId(),
                entity.getProductId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrencyIsoCode());
    }
}
