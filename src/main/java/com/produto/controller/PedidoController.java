package com.produto.controller;

import com.produto.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private JdbcTemplate jdbc;

    @PostMapping()
    public String criarPedido(@RequestBody Pedido pedido) {

        String sql = new StringBuilder()
                .append("INSERT INTO REQUEST (DESCRIPTION, PRICE) VALUES ('")
                .append(pedido.descricao)
                .append("',")
                .append(pedido.preco)
                .append(")")
                .toString();

        jdbc.execute(sql);

        return "Pedido criado com sucesso";

    }

    @GetMapping("/id/{id}")
    public String buscaPedido(@PathVariable(name = "id") int id) {
        String sql = "select NAME from REQUEST where REQUEST_ID =" + id;

        String retorno;

        try {
            retorno = "Descricao do pedido = ";
            retorno += jdbc.queryForObject(sql, String.class);
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

}
