package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.FindLowStockProductsResponseDTO;

import java.util.List;

@FunctionalInterface
public interface FindLowStockProductsService {
    List<FindLowStockProductsResponseDTO> findLowStockProducts(Integer quantityLimit);
}
