package com.estoque.controle.estoque.product.dto;

import jakarta.validation.constraints.NotNull;

public class StockAdjusterRequestDTO {
    @NotNull
    private Integer quantity;

    public StockAdjusterRequestDTO() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
