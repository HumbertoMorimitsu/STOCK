package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.GetAllProductResponseDTO;

import java.util.List;

@FunctionalInterface
public interface GetAllProductService {
    List<GetAllProductResponseDTO> findAll();
}
