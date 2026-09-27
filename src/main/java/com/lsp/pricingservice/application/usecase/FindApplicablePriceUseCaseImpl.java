package com.lsp.pricingservice.application.usecase;

import com.lsp.pricingservice.application.exception.ErrorCode;
import com.lsp.pricingservice.application.exception.ServiceException;
import com.lsp.pricingservice.application.port.in.FindApplicablePriceUseCase;
import com.lsp.pricingservice.application.port.out.FindApplicablePricePort;
import com.lsp.pricingservice.domain.model.Price;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class FindApplicablePriceUseCaseImpl implements FindApplicablePriceUseCase {

    private final FindApplicablePricePort findApplicablePricePort;

    @Override
    public Price findApplicablePrice(Integer productId, Integer brandId, LocalDateTime applicationDate) {

        List<Price> prices = findApplicablePricePort.findApplicablePrice(productId, brandId, applicationDate);

//        List<String> list = null;
//        list.get(1);

        if (prices.isEmpty()) {
            throw new ServiceException(ErrorCode.PRICE_NOT_FOUND, productId, brandId);
        }

        if (prices.size() > 1) {
            throw new ServiceException(ErrorCode.DUPLICATED_PRICE, productId, brandId, applicationDate);
        }

        Price price = prices.getFirst();
        if (price == null) {
            throw new IllegalStateException("Applicable price cannot be null");
        }

        return price;
    }
}