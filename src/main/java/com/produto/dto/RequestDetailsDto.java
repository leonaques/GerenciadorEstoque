package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RequestDetailsDto {
    private String description;

    @JsonProperty(value = "costumer_id")
    private CustomerDetailsDto customer;

    @JsonProperty(value = "address_id")
    private AddressDetailsDto address;

    @JsonProperty(value = "products")
    private List<ProductDetailsDto> products;

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public List<ProductDetailsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailsDto> products) {
        this.products = products;
    }

    public CustomerDetailsDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetailsDto customer) {
        this.customer = customer;
    }

    public AddressDetailsDto getAddress() {
        return address;
    }

    public void setAddress(AddressDetailsDto address) {
        this.address = address;
    }

}


