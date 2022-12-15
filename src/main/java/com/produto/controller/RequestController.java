package com.produto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.produto.domain.Request;
import com.produto.dto.RequestDetailsDto;
import com.produto.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping()
    public String createRequest(@RequestBody RequestDetailsDto requestDetailsDto) throws JsonProcessingException {
        this.requestService.createRequest(requestDetailsDto);
        return this.objectMapper.writeValueAsString(requestDetailsDto);
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
