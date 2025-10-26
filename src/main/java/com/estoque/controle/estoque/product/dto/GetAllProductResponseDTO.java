package com.estoque.controle.estoque.product.dto;

import com.estoque.controle.estoque.product.jpa.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


public class GetAllProductResponseDTO {
    private String Cod;

    private String name;

    private Integer quantity;

    private CategoryEnum categoryEnum;

    private LocalDateTime createDateTime;

    private LocalDateTime updatedDateTime;

    public GetAllProductResponseDTO(String cod, String name, Integer quantity, CategoryEnum categoryEnum, LocalDateTime createDateTime, LocalDateTime updatedDateTime) {
        Cod = cod;
        this.name = name;
        this.quantity = quantity;
        this.categoryEnum = categoryEnum;
        this.createDateTime = createDateTime;
        this.updatedDateTime = updatedDateTime;
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
