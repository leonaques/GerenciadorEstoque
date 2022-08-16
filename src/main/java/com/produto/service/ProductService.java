package com.produto.service;

import com.produto.dao.ProductDAO;
import com.produto.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product save(Product product) {
        return this.productDAO.save(product);
    }

    public int delete (int id) {
        return this.productDAO.delete(id);
    }

    public Product find(int id) {
        return this.productDAO.find(id);
    }

    public List<Product> findAll() {
        return this.productDAO.findAll();
    }
}
