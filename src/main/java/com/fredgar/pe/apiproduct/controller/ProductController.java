package com.fredgar.pe.apiproduct.controller;

import com.fredgar.pe.apiproduct.domain.dto.ProductDTO;
import com.fredgar.pe.apiproduct.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{name}")
  public Flux<ProductDTO> findByName(@PathVariable String name) {
    return productService.findByName(name);
  }

  @PostMapping("/create")
  private Mono<ProductDTO> create(@RequestBody ProductDTO productDTO) {
    return productService.create(productDTO);
  }

}
