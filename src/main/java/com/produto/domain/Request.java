package com.produto.domain;

public class Request {

    public int requestId;
    public String description;
    public long price;

    public  Request(int requestId, String description, long price) {
        this.setId(requestId);
        this.setDescription(description);
        this.setPrice(price);
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
}
