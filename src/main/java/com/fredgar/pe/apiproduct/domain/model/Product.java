package com.fredgar.pe.apiproduct.domain.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  private String id;

  @NotEmpty(message = "El código no puede estar vacío")
  private String code;

  @NotEmpty(message = "El nombre no puede estar vacío")
  private String name;

  @NotEmpty(message = "El código encriptado no puede estar vacío")
  private String encriptedCode;

  @NotEmpty(message = "El EAN no puede estar vacío")
  private String ean;

  @NotNull(message = "El campo isActive no puede ser nulo")
  private Integer isActive;

  @NotNull(message = "El precio de venta no puede ser nulo")
  @DecimalMin(value = "0.0", inclusive = true, message = "El precio de venta debe ser mayor o igual a 0")
  private BigDecimal salesPrice;

  @NotNull(message = "El precio de venta con impuesto no puede ser nulo")
  @DecimalMin(value = "0.0", inclusive = true, message = "El precio de venta con impuesto debe ser mayor o igual a 0")
  private BigDecimal salesPriceWithTax;

  @NotNull(message = "El campo canBeSold no puede ser nulo")
  @Min(value = 0, message = "El valor de canBeSold debe ser 0 o 1")
  @Max(value = 1, message = "El valor de canBeSold debe ser 0 o 1")
  private Integer canBeSold;

  @NotNull(message = "El campo isDeleted no puede ser nulo")
  @Min(value = 0, message = "El valor de isDeleted debe ser 0 o 1")
  @Max(value = 1, message = "El valor de isDeleted debe ser 0 o 1")
  private Integer isDeleted;

  private String productLocation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime updated;
}
