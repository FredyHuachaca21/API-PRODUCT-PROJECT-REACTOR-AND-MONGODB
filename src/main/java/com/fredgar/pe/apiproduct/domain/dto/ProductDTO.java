package com.fredgar.pe.apiproduct.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDTO(
    String id,
    String code,
    String name,
    String encriptedCode,
    String ean,
    Integer isActive,
    BigDecimal salesPrice,
    BigDecimal salesPriceWithTax,
    Integer canBeSold,
    Integer isDeleted,
    String productLocation,
    LocalDateTime created,
    LocalDateTime updated
){}