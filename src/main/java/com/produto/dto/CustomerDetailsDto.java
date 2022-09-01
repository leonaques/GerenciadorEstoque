package com.produto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDetailsDto {

    private int id;

    private String name;

    private String lastName;
    @JsonProperty(value = "cpf")
    private double cpf;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public double getCpf() {return cpf;}

    public void setCpf(double cpf) {this.cpf = cpf;}
}
