package com.estoque.controle.estoque.product.service;

import com.estoque.controle.estoque.product.dto.GetAllProductResponseDTO;
import com.estoque.controle.estoque.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllProductServiceImpl implements GetAllProductService {

    private final ProductRepository productRepository;
    public GetAllProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<GetAllProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product ->  new GetAllProductResponseDTO(
                        product.getCod(),
                        product.getName(),
                        product.getQuantity(),
                        product.getCategory(),
                        product.getCreateDateTime(),
                        product.getUpdatedDateTime()

                ))
                .collect(Collectors.toList());
    }

}
