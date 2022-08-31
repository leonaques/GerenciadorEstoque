package com.produto.service;

import com.produto.dao.CustomerDAO;
import com.produto.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer save(Customer customer) {
        return this.customerDAO.save(customer);
    }

    public int delete (int id) {
        return this.customerDAO.delete(id);
    }

    public Customer find(int id) {
        return this.customerDAO.find(id);
    }

    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }
}
