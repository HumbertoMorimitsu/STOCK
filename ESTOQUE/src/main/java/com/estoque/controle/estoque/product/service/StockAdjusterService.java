package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.StockAdjusterRequestDTO;

@FunctionalInterface
public interface StockAdjusterService {
    void StockAdjuster(Long id, StockAdjusterRequestDTO stockAdjusterRequestDTO);
}
