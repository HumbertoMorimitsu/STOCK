package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.StockAdjusterRequestDTO;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StockAdjusterServiceImpl implements  StockAdjusterService{

    private final ProductRepository productRepository;

    public StockAdjusterServiceImpl (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void StockAdjuster(Long id, StockAdjusterRequestDTO stockAdjusterRequestDTO) {
        var  product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var productStockAdjuster =product.get();
        productStockAdjuster.setQuantity(stockAdjusterRequestDTO.getQuantity());
        productRepository.save(productStockAdjuster);
    }
}
