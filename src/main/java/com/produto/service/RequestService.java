package com.produto.service;


import com.produto.dao.RequestDAO;
import com.produto.domain.Product;
import com.produto.domain.Request;
import com.produto.dto.ProductDetailsDto;
import com.produto.dto.RequestDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestDAO requestDAO;

    @Autowired
    private ProductService productService;

    public void createRequest(final RequestDetailsDto requestDetailsDto) {

        long totalRequestPrice = 0;

        List<Product> products = new ArrayList<>();

        for (ProductDetailsDto productDetailsDto : requestDetailsDto.getProducts()) {
            Product product = productService.find(productDetailsDto.getId());

            totalRequestPrice += productDetailsDto.getQuantity() * product.getPrice();
        }

        Request request = new Request(requestDetailsDto, totalRequestPrice);

        this.requestDAO.save(request);

    }

    public Request save(Request request) {
        return this.requestDAO.save(request);
    }

    public int delete (int id) {
        return this.requestDAO.delete(id);
    }

    public Request find(int id) {
        return this.requestDAO.find(id);
    }

    public List<Request> findAll() {
        return this.requestDAO.findAll();
    }
    
}
