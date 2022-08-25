package com.produto.dao;

import com.produto.domain.Product;
import com.produto.domain.Request;
import com.produto.dto.ProductDetailsDto;
import com.produto.dto.RequestDetailsDto;
import com.produto.exception.QueryResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public Product save(Product product) {

        String sql = new StringBuilder()
                .append("INSERT INTO PRODUCT (NAME, PRICE) VALUES ('")
                .append(product.getName())
                .append("',")
                .append(product.getPrice())
                .append(")")
                .toString();

        jdbc.execute(sql);

        return product;
    }


    public Product find(int id) {

        String sql = "select NAME, PRICE from PRODUCT where PRODUCT_ID =" + id;

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        if (queryReturn.size() != 1) {
            throw new QueryResultException();
        }

        var objectReturn = queryReturn.get(0);

        String name = objectReturn.get("NAME").toString();
        var price = ((BigDecimal) objectReturn.get("PRICE")).longValue();

        var product = new Product(id, name, price);

        return new Product(id, name, price);
    }

    public int delete(int id) {

        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        return qtdDeletado;
    }

    public List<Product> findAll(){
        String sql = "select NAME, PRICE, PRODUCT_ID from PRODUCT";

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        List<Product> products = new ArrayList<>();
        for (Map<String, Object> map:queryReturn) {
            String name = map.get("NAME").toString();
            var price = ((BigDecimal) map.get("PRICE")).longValue();
            int id = (Integer) map.get("PRODUCT_ID");
            var product = new Product(id, name, price);
            products.add(product);
        }

        return products;
    }

}
