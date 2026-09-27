package com.lsp.pricingservice.infrastructure.out.persistence.jpa.mapper;

import com.lsp.pricingservice.domain.model.Price;
import com.lsp.pricingservice.infrastructure.out.persistence.jpa.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price toDomain(PriceEntity entity);
}
