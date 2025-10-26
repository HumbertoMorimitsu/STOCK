package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.UpdatedProductRequestDTO;

@FunctionalInterface
public interface UpdatedProductService {
     void updatedProduct(Long Id, UpdatedProductRequestDTO updatedProductRequestDTO);
}
