package com.produto.dao;


import com.produto.domain.Product;
import com.produto.domain.Request;
import com.produto.exception.QueryResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RequestDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public Request save(Request request) {
        String sqlInsertRequest = new StringBuilder()
                .append("INSERT INTO REQUEST (DESCRIPTION, PRICE) VALUES ('")
                .append(request.getDescription())
                .append("',")
                .append(request.getPrice())
                .append(")")
                .append(" returning REQUEST_ID")
                .toString();
        final int id = jdbc.queryForObject(sqlInsertRequest, Integer.class);

        for (Product product: request.getProducts()) {

            String sqlInsertProduct = new StringBuilder()
                    .append("INSERT INTO PRODUCT_REQUEST (REQUEST_ID, PRODUCT_ID, QUANTITY) VALUES (")
                    .append(id)
                    .append(" , ")
                    .append(product.getId())
                    .append(" , ")
                    .append(product.getQuantity())
                    .append(")")
                    .toString();

            this.jdbc.execute(sqlInsertProduct);
        }


            String sqlInsertAddress = new StringBuilder()
                    .append("INSERT INTO REQUEST_ADDRESS (REQUEST_ID, ADDRESS_ID) VALUES (")
                    .append(id)
                    .append(" , ")
                    .append(request.getAddresses().getId())
                    .append(")")
                    .toString();


            this.jdbc.execute(sqlInsertAddress);


            String sqlInsertCustomer = new StringBuilder()
                    .append("INSERT INTO REQUEST_CUSTOMER (REQUEST_ID, CUSTOMER_ID) VALUES (")
                    .append(id)
                    .append(" , ")
                    .append(request.getAddresses().getId())
                    .append(")")
                    .toString();

            this.jdbc.execute(sqlInsertCustomer);


        return request;
    }

    public Request find(int id) {

        String sql = "select DESCRIPTION, PRICE from REQUEST where REQUEST_ID =" + id;

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        if (queryReturn.size() != 1) {
            throw new QueryResultException();
        }

        var objectReturn = queryReturn.get(0);

        String name = objectReturn.get("DESCRIPTION").toString();
        var price = ((BigDecimal) objectReturn.get("PRICE")).longValue();

        var request = new Request(id, name, price);

        return new Request(id, name, price);
    }

    public int delete(int id) {

        String sql = "DELETE FROM REQUEST WHERE REQUEST_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        return qtdDeletado;
    }

    public List<Request> findAll(){
        String sql = "select DESCRIPTION, PRICE, REQUEST_ID from REQUEST";

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        List<Request> requests = new ArrayList<>();
        for (Map<String, Object> map:queryReturn) {
            String description = map.get("DESCRIPTION").toString();
            var price = ((BigDecimal) map.get("PRICE")).longValue();
            int id = (Integer) map.get("REQUEST_ID");
            var request = new Request(id, description, price);
            requests.add(request);
        }

        return requests;
    }

}
