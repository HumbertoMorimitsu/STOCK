package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.FindLowStockProductsResponseDTO;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindLowStockProductsServiceImpl implements FindLowStockProductsService{

    private final ProductRepository productRepository;

    public FindLowStockProductsServiceImpl (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<FindLowStockProductsResponseDTO> findLowStockProducts(Integer quantityLimit) {
        return productRepository.findLowStockProducts(quantityLimit);
    }


}
