package com.produto.controller;

import com.produto.domain.Product;
import com.produto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public String createProduct(@RequestBody Product product) {
        this.productService.save(product);
        return "Registro inserido com sucesso";
    }

    @GetMapping("/id/{id}")
    public Product findProduct(@PathVariable(name = "id") int id) {
        return this.productService.find(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteProduct(@PathVariable(name = "id") int id) {
        return this.productService.delete(id);

    }

    @GetMapping
    public List<Product> findAllProducts() {
        return this.productService.findAll();
    }
}
