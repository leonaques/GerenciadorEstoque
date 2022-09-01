package com.produto.dto;

public class ProductDetailsDto {
    private int id;

    private String description;
    private int quantity;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {return description;}

}
