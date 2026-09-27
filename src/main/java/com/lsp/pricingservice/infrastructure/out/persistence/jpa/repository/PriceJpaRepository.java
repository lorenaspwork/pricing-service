package com.lsp.pricingservice.infrastructure.out.persistence.jpa.repository;

import com.lsp.pricingservice.infrastructure.out.persistence.jpa.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {

    @Query("""
    SELECT p
    FROM PriceEntity p
    WHERE p.productId = :productId
      AND p.brandId = :brandId
      AND p.startDate <= :applicationDate
      AND p.endDate >= :applicationDate
      AND p.priority = (
          SELECT MAX(p2.priority)
          FROM PriceEntity p2
          WHERE p2.productId = :productId
            AND p2.brandId = :brandId
            AND p2.startDate <= :applicationDate
            AND p2.endDate >= :applicationDate
      )
    """)
    List<PriceEntity> findApplicablePrice(
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
