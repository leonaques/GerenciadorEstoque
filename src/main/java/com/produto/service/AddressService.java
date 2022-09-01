package com.produto.service;

import com.produto.dao.AddressDAO;
import com.produto.domain.Address;
import com.produto.domain.Customer;
import com.produto.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public Address save (Address address){return this.addressDAO.save(address);}

    public int delete (int id) {
        return this.addressDAO.delete(id);
    }

    public Address find(int id) {
        return this.addressDAO.find(id);
    }

    public List<Address> findAll() {return this.addressDAO.findAll();}

    public Address update(Address address){return this.addressDAO.update(address);}
}
