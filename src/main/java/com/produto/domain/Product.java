package com.produto.domain;

public class Product {

    private int id;
    private String name;
    private long price;

    public  Product(int id, String name, long price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
    }

    public Product(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        if (price < 0) {
            price =0;
        }
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
