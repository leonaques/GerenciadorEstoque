package com.produto.dao;

import com.produto.domain.Address;
import com.produto.exception.QueryResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AddressDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public Address save (Address address) {
        String sql = new StringBuilder()
                .append("INSERT INTO ADDRESS (STREET, DISTRICT, COUNTRY, NUMBER, CEP) VALUES ('")
                .append(address.getStreet())
                .append("','")
                .append(address.getDistrict())
                .append("','")
                .append(address.getCountry())
                .append("',")
                .append(address.getNumber())
                .append(",")
                .append(address.getCep())
                .append(")")
                .toString();

        jdbc.execute(sql);

        return address;
    }

    public int delete(int id) {

        String sql = "DELETE FROM ADDRESS WHERE ADDRESS_ID = " + id;

        int qtdDeletado = jdbc.update(sql);

        return qtdDeletado;
    }

    public Address find(int id) {

        String sql = "select STREET, NUMBER, DISTRICT, COUNTRY, CEP  from ADDRESS where ADDRESS_ID =" + id;

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        if (queryReturn.size() != 1) {
            throw new QueryResultException();
        }

        var objectReturn = queryReturn.get(0);

        String street = objectReturn.get("STREET").toString();
        var number = ((BigDecimal) objectReturn.get("NUMBER")).longValue();
        String district = objectReturn.get("DISTRICT").toString();
        String country = objectReturn.get("COUNTRY").toString();
        var cep = ((BigDecimal) objectReturn.get("CEP")).longValue();

        var address = new Address(id, (int) cep, street, (int) number, district, country);

        return new Address(id, (int) cep, street, (int) number, district, country);
    }

    public List<Address> findAll(){
        String sql = "select STREET, NUMBER, DISTRICT, COUNTRY, CEP, ADDRESS_ID from ADDRESS";

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        List<Address> allAddress = new ArrayList<>();
        for (Map<String, Object> map:queryReturn) {
            String street = map.get("STREET").toString();
            var number = ((BigDecimal) map.get("NUMBER")).longValue();
            String district = map.get("DISTRICT").toString();
            String country = map.get("COUNTRY").toString();
            var cep = ((BigDecimal) map.get("CEP")).longValue();
            int id = (Integer) map.get("ADDRESS_ID");
            var address = new Address(id, (int) cep, street, (int) number, district, country);
            allAddress.add(address);
        }

        return allAddress;
    }


}
