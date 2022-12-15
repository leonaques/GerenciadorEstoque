package com.produto.domain;

import com.produto.dto.RequestDetailsDto;

import java.util.List;

public class Request {

    private int requestId;
    private String description;
    private long price;
    private List<Product> products;

    private Address addresses;

    private Customer customers;

    public  Request(int requestId, String description, long price) {
        this.setId(requestId);
        this.setDescription(description);
        this.setPrice(price);
    }

    public Request(RequestDetailsDto requestDetailsDto, long price, List<Product> productList, Address addresses, Customer customers) {
        this.setDescription(requestDetailsDto.getDescription());
        this.setPrice(price);
        this.setProductsList(productList);
        this.setAddresses(addresses);
        this.setCustomers(customers);
    }

    public void setPrice(long price) {
        if (price < 0) {
            price =0;
        }
        this.price = price;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setId(int requestId) {
        this.requestId=requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }

    public void setProductsList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {return products;}

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

}
