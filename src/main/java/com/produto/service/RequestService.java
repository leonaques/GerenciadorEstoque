package com.produto.service;


import com.produto.dao.RequestDAO;
import com.produto.domain.Address;
import com.produto.domain.Customer;
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

    @Autowired
    private AddressService addressService;

    @Autowired
    private  CustomerService customerService;


    public void createRequest(final RequestDetailsDto requestDetailsDto) {

        List<Product> productList = new ArrayList<>();


        for (ProductDetailsDto productDetailsDto : requestDetailsDto.getProducts()) {
            Product product = productService.find(productDetailsDto.getId());
            product.setQuantity(productDetailsDto.getQuantity());
            productList.add(product);

        }
            Address address = addressService.find(requestDetailsDto.getAddress().getId());


            Customer customer = customerService.find(requestDetailsDto.getCustomer().getId());



        final var totalPrice = productList.stream().mapToLong(Product::getPrice).sum();

        Request request = new Request(requestDetailsDto.getDescription(), totalPrice, productList, address, customer);

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

    public List<Request> findAll() {return this.requestDAO.findAll();}
    
}
