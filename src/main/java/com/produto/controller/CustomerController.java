package com.produto.controller;


import com.produto.domain.Customer;
import com.produto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping()
    public String createCustomer(@RequestBody Customer customer) {
        this.customerService.save(customer);
        return "Cadastro realizado com sucesso!";
    }

    @GetMapping("/id/{id}")
    public Customer findProduct(@PathVariable(name = "id") int id) {
        return this.customerService.find(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteCustomer(@PathVariable(name = "id") int id) {
        return this.customerService.delete(id);

    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return this.customerService.findAll();
    }

    @PostMapping("/update")
    public String updateCustomer (@RequestBody Customer customer){
        this.customerService.update(customer);
        return "Cadastro alterado com sucesso!";
    }
}

