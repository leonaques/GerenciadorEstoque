package com.produto.dao;

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
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RequestDAOTest {

    @InjectMocks
    public RequestDAO requestDAO;

    @Mock
    public JdbcTemplate jdbcTemplate;

    @Test
    public void shouldThrownQueryResultExceptionWhenQueryReturn2Results() {
        List<Map<String, Object>> ret = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        map.put("Test", new Object());

        ret.add(map);

        Mockito.when(this.jdbcTemplate.queryForList(ArgumentMatchers.anyString())).thenReturn(ret);

        Assertions.assertThrows(QueryResultException.class, () -> this.requestDAO.find(1));
    }

    @Test
    public void shouldReturnValidRequest() {
        List<Map<String, Object>> ret = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        map.put("DESCRIPTION", "Pedido do ze");
        map.put("PRICE", BigDecimal.TEN);

        ret.add(map);

        Mockito.when(this.jdbcTemplate.queryForList(ArgumentMatchers.anyString())).thenReturn(ret);

        Request request = this.requestDAO.find(1);

        assertEquals("Incorrect description!", "Pedido do ze", request.getDescription());
        assertEquals("Incorrect price!", 10L, request.getPrice());
    }

}
