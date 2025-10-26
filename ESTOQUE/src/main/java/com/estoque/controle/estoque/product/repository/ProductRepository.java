package com.estoque.controle.estoque.product.repository;

import com.estoque.controle.estoque.product.dto.FindLowStockProductsResponseDTO;
import com.estoque.controle.estoque.product.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT new com.estoque.controle.estoque.product.dto.FindLowStockProductsResponseDTO( p.cod, p.name, p.category, p.quantity) FROM Product p WHERE p.quantity < :quantity")
    List<FindLowStockProductsResponseDTO> findLowStockProducts(@Param("quantity") Integer quantity);



    /*
    @Query("SELECT p FROM Product p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Product> buscarPorNome(@Param("nome") String nome);
    */
}