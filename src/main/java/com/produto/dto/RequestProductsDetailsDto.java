package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestProductsDetailsDto {

    private String name;
    private Long price;
    private int quantity;
    private Long totalPrice;
}