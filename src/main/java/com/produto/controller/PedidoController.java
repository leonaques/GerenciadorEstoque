package com.produto.controller;

import com.produto.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private JdbcTemplate jdbc;

    @PostMapping()
    public String criarPedido(@RequestBody Pedido pedido) {

        String sql = new StringBuilder()
                .append("INSERT INTO REQUEST (DESCRIPTION, PRICE) VALUES ('")
                .append(pedido.description)
                .append("',")
                .append(pedido.price)
                .append(")")
                .toString();

        jdbc.execute(sql);

        return "Pedido criado com sucesso";

    }

    @GetMapping("/id/{id}")
    public String buscaPedido(@PathVariable(name = "id") int id) {
        String sql = "select DESCRIPTION, PRICE from REQUEST where REQUEST_ID =" + id;

        String retorno = "";

        try {
            List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

            for (Map<String, Object> map:queryReturn) {
                retorno = "Descricao do pedido = ";
                retorno += map.get("description");
                retorno += ("/ Preço do produto = ");
                retorno += map.get("PRICE");
            }
        } catch (EmptyResultDataAccessException e) {
            retorno = "O pedido informado nao existe!";
        }

        return retorno;
    }

    @DeleteMapping("/id/{id}")
    public String deletaProduto(@PathVariable(name = "id") int id) {
        String sql = "DELETE FROM REQUEST WHERE REQUEST_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        if (qtdDeletado == 0) {
            return "Pedido nao encontrado!";
        }

        return "Pedido com id " + id + " deletado com sucesso";
    }

    @GetMapping
    public String buscaTotal() {
        String sql = "select DESCRIPTION, PRICE from REQUEST";

        String retorno = "";

        try {
            List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

            for (Map<String, Object> map:queryReturn) {
                retorno += "Descricao do pedido = ";
                retorno += map.get("description");
                retorno += ("/ Preço do produto = ");
                retorno += map.get("PRICE");
                retorno += ("\n");
            }
        } catch (EmptyResultDataAccessException e) {
            retorno = "O pedido informado nao existe!";
        }

        return retorno;
    }

}
