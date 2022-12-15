package com.produto.dto;

public class AddressDetailsDto {

    private int id;

    private int cep;

    private String street;

    private int number;

    private String district;

    private String country;

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
