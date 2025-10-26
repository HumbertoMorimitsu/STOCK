package com.estoque.controle.estoque.product.dto;

import com.estoque.controle.estoque.product.jpa.CategoryEnum;
import jakarta.validation.constraints.NotNull;

public class CreateProductRequestDTO {
    @NotNull
    private String Cod;

    @NotNull
    private String name;

    @NotNull
    private Integer quantity;

    @NotNull
    private CategoryEnum categoryEnum;

    public CreateProductRequestDTO() {
    }

    public CreateProductRequestDTO(String cod, String name, Integer quantity, CategoryEnum categoryEnum) {
        Cod = cod;
        this.name = name;
        this.quantity = quantity;
        this.categoryEnum = categoryEnum;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String cod) {
        Cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
