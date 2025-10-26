package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.UpdatedProductRequestDTO;
import com.estoque.controle.estoque.product.jpa.Product;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdatedProductServiceImpl implements UpdatedProductService{

    private final ProductRepository productRepository;

    public UpdatedProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public  void updatedProduct(Long id, UpdatedProductRequestDTO updatedProductRequestDTO){
        var  product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var productUpdated =product.get();
        productUpdated.setCod(updatedProductRequestDTO.getCod());
        productUpdated.setName(updatedProductRequestDTO.getName());
        productUpdated.setQuantity(updatedProductRequestDTO.getQuantity());
        productUpdated.setCategory(updatedProductRequestDTO.getCategoryEnum());
        productUpdated.setUpdatedDateTime(LocalDateTime.now());

        productRepository.save(productUpdated);
    }
}
