package com.produto.dao;

import com.produto.domain.Customer;
import com.produto.domain.Product;
import com.produto.exception.QueryResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public Customer save(Customer customer) {

        String sql = new StringBuilder()
                .append("INSERT INTO CUSTOMER (NAME, LAST_NAME, CPF) VALUES ('")
                .append(customer.getName())
                .append("','")
                .append(customer.getLastName())
                .append("',")
                .append(customer.getCpf())
                .append(")")
                .toString();

        jdbc.execute(sql);

        return customer;
    }
    public Customer update(Customer customer) {

        String sql = new StringBuilder()
                .append("UPDATE CUSTOMER SET NAME='")
                .append(customer.getName())
                .append("', LAST_NAME= '")
                .append(customer.getLastName())
                .append("', CPF= '")
                .append(customer.getCpf())
                .append("' WHERE CUSTOMER_ID = ")
                .append(customer.getId())
                .toString();

        jdbc.execute(sql);

        return customer;
    }
    public int delete(int id) {

        String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        return qtdDeletado;
    }

    public Customer find(int id) {

        String sql = "select NAME, LAST_NAME, CPF from CUSTOMER where CUSTOMER_ID =" + id;

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        if (queryReturn.size() != 1) {
            throw new QueryResultException();
        }

        var objectReturn = queryReturn.get(0);

        String name = objectReturn.get("NAME").toString();
        String lastName = objectReturn.get("LAST_NAME").toString();
        var cpf = ((BigDecimal) objectReturn.get("CPF")).longValue();

        var customer = new Customer(id, name, lastName, (int) cpf);

        return new Customer(id, name, lastName, (int) cpf);
    }

    public List<Customer> findAll(){
        String sql = "select NAME, LAST_NAME, CUSTOMER_ID, CPF from CUSTOMER";

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        List<Customer> customers = new ArrayList<>();
        for (Map<String, Object> map:queryReturn) {
            String name = map.get("NAME").toString();
            String lastName = map.get("LAST_NAME").toString();
            var cpf = ((BigDecimal) map.get("CPF")).longValue();
            int id = (Integer) map.get("CUSTOMER_ID");
            var customer = new Customer(id, name, lastName, (int) cpf);
            customers.add(customer);
        }

        return customers;
    }
}
