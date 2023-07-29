package com.fredgar.pe.apiproduct.domain.mapper;

import com.fredgar.pe.apiproduct.domain.dto.ProductDTO;
import com.fredgar.pe.apiproduct.domain.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "code", target = "code")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "encriptedCode", target = "encriptedCode")
  @Mapping(source = "ean", target = "ean")
  @Mapping(source = "isActive", target = "isActive")
  @Mapping(source = "salesPrice", target = "salesPrice")
  @Mapping(source = "salesPriceWithTax", target = "salesPriceWithTax")
  @Mapping(source = "canBeSold", target = "canBeSold")
  @Mapping(source = "isDeleted", target = "isDeleted")
  @Mapping(source = "productLocation", target = "productLocation")
  @Mapping(source = "created", target = "created")
  @Mapping(source = "updated", target = "updated")
  ProductDTO productToProductDTO(Product product);

  @InheritInverseConfiguration
  Product productDTOToProduct(ProductDTO productDto);

}
