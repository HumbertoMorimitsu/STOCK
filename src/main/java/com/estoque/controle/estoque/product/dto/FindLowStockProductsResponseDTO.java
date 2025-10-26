package com.estoque.controle.estoque.product.dto;


import com.estoque.controle.estoque.product.jpa.CategoryEnum;

public class FindLowStockProductsResponseDTO {

    private String cod;

    private String name;

    private CategoryEnum categoryEnum;

    private Integer quantity;

    public FindLowStockProductsResponseDTO(String cod, String name, CategoryEnum categoryEnum, Integer quantity) {
        this.cod = cod;
        this.name = name;
        this.categoryEnum = categoryEnum;
        this.quantity = quantity;
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

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}