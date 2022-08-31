package com.produto.controller;

import com.produto.domain.Address;
import com.produto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @PostMapping()
    public String createAddress(@RequestBody Address address) {
        this.addressService.save(address);
        return "Endereço cadastrado com sucesso!";
    }
    @GetMapping("/id/{id}")
    public Address findAddress(@PathVariable(name = "id") int id) {
        return this.addressService.find(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteAddress(@PathVariable(name = "id") int id) {
        return this.addressService.delete(id);

    }

    @GetMapping
    public List<Address> findAllAddress() {
        return this.addressService.findAll();
    }
}
