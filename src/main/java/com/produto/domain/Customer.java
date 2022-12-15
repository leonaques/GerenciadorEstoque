package com.produto.domain;


public class Customer {

    private int id;

    private String name;

    private String lastName;

    private double cpf;


    public  Customer(int id, String name, String lastName, double cpf) {
        this.setId(id);
        this.setName(name);
        this.setLastName(lastName);
        this.setCpf(cpf);
    }

    public Customer() {

    }


    public int getId() {return id;}

    public String getName() {return name;}

    public String getLastName() {return lastName;}

    public double getCpf() {return cpf;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setCpf(double cpf) {this.cpf = cpf;}
}
