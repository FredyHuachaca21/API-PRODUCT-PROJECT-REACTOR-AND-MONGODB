package com.fredgar.pe.apiproduct.domain.service;

import com.fredgar.pe.apiproduct.domain.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
  Flux<ProductDTO> findByName(String name);
  Mono<ProductDTO> create(ProductDTO productDTO);
}
