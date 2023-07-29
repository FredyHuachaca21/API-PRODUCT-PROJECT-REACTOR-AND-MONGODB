package com.fredgar.pe.apiproduct.domain.service;

import com.fredgar.pe.apiproduct.domain.dto.ProductDTO;
import com.fredgar.pe.apiproduct.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

  private final ProductRepository productRepository;

  @Override
  public Flux<ProductDTO> findByName(String name) {
    return productRepository.findByName(name)
        .map(product ->
           new ProductDTO(
               product.getId(),
               product.getCode(),
               product.getName(),
               product.getEncriptedCode(),
               product.getEan(),
               product.getIsActive(),
               product.getSalesPrice(),
               product.getSalesPriceWithTax(),
               product.getCanBeSold(),
               product.getIsDeleted(),
               product.getProductLocation(),
               product.getCreated(),
               product.getUpdated()
          )
        )
        .onErrorResume(error -> {
          log.error("Error al buscar por nombre: " + error.getMessage());
          return Flux.error(new RuntimeException("Error al buscar por nombre: " + error.getMessage()));
        });
  }

  @Override
  public Mono<ProductDTO> create(ProductDTO productDTO) {
    return null;
  }
}
