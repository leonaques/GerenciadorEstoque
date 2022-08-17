package com.produto.controller;

import com.produto.domain.Request;
import com.produto.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping()
    public String createRequest(@RequestBody Request request) {
        this.requestService.save(request);
        return "Pedido criado com sucesso";
    }

    @GetMapping("/id/{id}")
    public Request findRequest(@PathVariable(name = "id") int id) {
        return this.requestService.find(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteRequest(@PathVariable(name = "id") int id) {
        return this.requestService.delete(id);
    }

    @GetMapping
    public List<Request> findAllRequests() {
        return this.requestService.findAll();
    }

}
