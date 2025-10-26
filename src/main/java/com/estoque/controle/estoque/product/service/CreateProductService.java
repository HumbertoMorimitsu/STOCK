package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.CreateProductRequestDTO;

@FunctionalInterface
public interface CreateProductService {
    void createProduct(CreateProductRequestDTO createProductRequestDTO);
}
