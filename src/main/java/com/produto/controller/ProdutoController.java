package com.produto.controller;

import com.produto.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private JdbcTemplate jdbc;

    @PostMapping()
    public String criarProduto(@RequestBody Produto produto) {

        String sql = new StringBuilder()
                .append("INSERT INTO PRODUCT (NAME, PRICE) VALUES ('")
                .append(produto.nome)
                .append("',")
                .append(produto.preco)
                .append(")")
                .toString();

        jdbc.execute(sql);

        return "Registro inserido com sucesso";

    }

    @GetMapping("/id/{id}")
    public String buscaProduto(@PathVariable(name = "id") int id) {
        String sql = "select NAME from PRODUCT where PRODUCT_ID =" + id;

        String retorno;

        try {
            retorno = "Nome do produto = ";
            retorno += jdbc.queryForObject(sql, String.class);
        } catch (EmptyResultDataAccessException e) {
            retorno = "O produto informado nao existe!";
        }

        return retorno;
    }

    @DeleteMapping("/id/{id}")
    public String deletaProduto(@PathVariable(name = "id") int id) {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        if (qtdDeletado == 0) {
            return "Produto nao encontrado!";
        }

        return "Produto com id " + id + " deletado com sucesso";
    }
}
