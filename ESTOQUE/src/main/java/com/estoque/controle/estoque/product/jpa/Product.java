package com.estoque.controle.estoque.product.jpa;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;


@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String cod;
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private Integer quantity;

    private LocalDateTime createDateTime;

    private LocalDateTime updatedDateTime;


    public Product() {
    }

    @Builder
    public Product(String cod, String name, CategoryEnum category, Integer quantity) {
        this.cod = cod;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
