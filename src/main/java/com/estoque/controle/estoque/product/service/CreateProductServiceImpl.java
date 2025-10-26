package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.CreateProductRequestDTO;
import com.estoque.controle.estoque.product.jpa.Product;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateProductServiceImpl implements CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void createProduct(CreateProductRequestDTO dto) {
        Product product = new Product();
        product.setCod(dto.getCod());
        product.setName(dto.getName());
        product.setCategory(dto.getCategoryEnum());
        product.setQuantity(dto.getQuantity());
        product.setCreateDateTime(LocalDateTime.now());

        // ✅ Salvando no banco
        productRepository.save(product);
    }
}
