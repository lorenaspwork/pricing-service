package com.lsp.pricingservice.infrastructure.out.persistence.jpa.adapter;

import com.lsp.pricingservice.application.port.out.FindApplicablePricePort;
import com.lsp.pricingservice.domain.model.Price;
import com.lsp.pricingservice.infrastructure.out.persistence.jpa.mapper.PriceEntityMapper;
import com.lsp.pricingservice.infrastructure.out.persistence.jpa.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricePersistenceAdapter implements FindApplicablePricePort {

    private final PriceJpaRepository repository;

    private final PriceEntityMapper mapper;

    @Override
    public List<Price> findApplicablePrices(Integer productId, Integer brandId, LocalDateTime applicationDate) {
        return repository.findApplicablePrice(productId, brandId, applicationDate, Limit.of(2))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

}
