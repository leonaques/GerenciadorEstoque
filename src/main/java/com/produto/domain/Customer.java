package com.produto.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private int id;

    private String name;

    private String lastName;

    @JsonProperty(required = true)
    private int cpf;

    public  Customer(int id, String name, String lastName, int cpf) {
        this.setId(id);
        this.setName(name);
        this.setLastName(lastName);
        this.setCpf(cpf);
    }
    public Customer(){}


    public int getId() {return id;}

    public String getName() {return name;}

    public String getLastName() {return lastName;}

    public int getCpf() {return cpf;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setCpf(int cpf) {this.cpf = cpf;}
}
