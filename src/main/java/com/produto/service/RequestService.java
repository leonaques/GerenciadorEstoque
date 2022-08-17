package com.produto.service;


import com.produto.dao.RequestDAO;
import com.produto.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestDAO requestDAO;

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
