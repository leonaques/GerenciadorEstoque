package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.SettingDefinition;

import java.util.List;

public class RequestDetailsDto {
    private String description;
    @JsonProperty(value = "products")
    private List<ProductDetailsDto> products;

    @JsonProperty(value = "costumer_id")
    private long costumerId;

    @JsonProperty(value = "address_id")
    private long addressId;
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
