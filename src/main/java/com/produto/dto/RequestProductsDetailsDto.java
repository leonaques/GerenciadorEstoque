package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestProductsDetailsDto {

    @JsonProperty(value = "NAME")
    private String name;

    @JsonProperty
    private Long price;
    private int quantity;
    private Long totalPrice;
}