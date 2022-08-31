package com.produto.domain;

public class Address {

    private int id;

    private int cep;

    private String street;

    private int number;

    private String district;

    private String country;

    public Address(int id, int cep, String street, int number, String district, String country) {
        this.setId(id);
        this.setCep(cep);
        this.setStreet(street);
        this.setNumber(number);
        this.setDistrict(district);
        this.setCountry(country);
    }

    public Address (){}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getCep() {return cep;}

    public void setCep(int cep) {this.cep = cep;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public int getNumber() {return number;}

    public void setNumber(int number) {this.number = number;}

    public String getDistrict() {return district;}

    public void setDistrict(String district) {this.district = district;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}


}
