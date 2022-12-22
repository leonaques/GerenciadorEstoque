package com.produto.dao;

import com.produto.domain.Address;
import com.produto.domain.Customer;
import com.produto.domain.Product;
import com.produto.domain.Request;
import com.produto.exception.QueryResultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class RequestDAOTest {

    @Autowired
    public RequestDAO requestDAO;

    //@Mock
    //public JdbcTemplate jdbcTemplate;

    @Test
    public void shouldThrownQueryResultExceptionWhenQueryReturn2Results() {
        List<Map<String, Object>> ret = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        map.put("Test", new Object());
        map.put("Test1", new Object());

        ret.add(map);

        //Mockito.when(this.jdbcTemplate.queryForList(ArgumentMatchers.anyString())).thenReturn(ret);

        Assertions.assertThrows(QueryResultException.class, () -> this.requestDAO.find(1));
    }

    @Test
    public void shouldReturnValidRequest() {

        Product product = new Product("Jose", 10L);

        List<Product> products = new ArrayList<>();
        products.add(product);

        Address address = new Address(1, 123, "Rua jo joao", 1, "Franca", "Brasil", "Joao", "Jose");

        Customer customer = new Customer(1, "Jose" , "Joao", 213131);

        Request request = new Request("Pedido do ze", 10L, products, address, customer);

        this.requestDAO.save(request);

        Request requestToValidate = this.requestDAO.find(1);

        assertEquals("Incorrect description!", "Pedido do ze", requestToValidate.getDescription());
        assertEquals("Incorrect price!", 10L, requestToValidate.getPrice());
    }

}
