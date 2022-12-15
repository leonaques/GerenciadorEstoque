package com.produto.controller;

import com.produto.domain.Address;
import com.produto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customeraddress/{id}")
    public Address findAddressCustomerId(@PathVariable(name = "id") int id) {
        return this.addressService.find(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteAddress(@PathVariable(name = "id") int id) {
        return this.addressService.delete(id);

    }

    @PutMapping ("/update")
    public String updateAddress(@RequestBody Address address) {
        this.addressService.update(address);
        return "Endereço alterado com sucesso!";
    }
}
