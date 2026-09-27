package com.lsp.pricingservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {

    private final Integer id;

    private final Integer brandId;

    private final Integer productId;

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final Integer priceList;

    private final Integer priority;

    private final BigDecimal price;

    private final String currencyIsoCode;


    public Price(Integer id, Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate,
                 Integer priceList, Integer priority, BigDecimal price, String currencyIsoCode) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currencyIsoCode = currencyIsoCode;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", productId=" + productId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", price=" + price +
                ", currencyIsoCode='" + currencyIsoCode + '\'' +
                '}';
    }
}