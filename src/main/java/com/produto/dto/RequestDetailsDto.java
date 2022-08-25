package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.SettingDefinition;

import java.util.List;

public class RequestDetailsDto {
    private String description;
    @JsonProperty(value = "products")
    private List<ProductDetailsDto> products;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducts(List<ProductDetailsDto> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public List<ProductDetailsDto> getProducts() {
        return products;
    }
}
