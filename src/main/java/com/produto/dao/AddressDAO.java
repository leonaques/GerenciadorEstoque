package com.produto.dao;

import com.produto.domain.Address;
import com.produto.domain.Customer;
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
                .append("returning ADDRESS_ID")
                .toString();
        final int id = jdbc.queryForObject(sql, Integer.class);
        jdbc.execute(sql);

        sql = new StringBuilder()
                .append("INSERT INTO CUSTOMER_ADDRESS (CUSTOMER_ID, ADDRESS_ID) VALUES ('")
                .append(address.getCustomer().getId())
                .append("','")
                .append(address.getId())
                .append("')")
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
        String customerName = objectReturn.get("c.name").toString();
        String customerLastName = objectReturn.get("c.last_name").toString();

        var address = new Address(id, (int) cep, street, (int) number, district, country, customerName, customerLastName);

        return new Address(id, (int) cep, street, (int) number, district, country, customerName, customerLastName);
    }

    public Address findAddressCustomerId(int id) {

        String sql = new StringBuilder()
                .append("select  ca.customer_id, ca.address_id, c.name, c.last_name, a.STREET, a.NUMBER, a.DISTRICT, a.COUNTRY, a.CEP from customer_address ca " +
                        "join  customer c on c.customer_id = ca.customer_id " +
                        "join address a on a.address_id = ca.address_id" +
                        " where c.customer_id =")
                .append(findAddressCustomerId(id).getCustomer().getId())
                .toString();


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
        String customerName = objectReturn.get("c.name").toString();
        String customerLastName = objectReturn.get("c.last_name").toString();


        var address = new Address(id, (int) cep, street, (int) number, district, country, customerName, customerLastName);

        return new Address(id, (int) cep, street, (int) number, district, country, customerName, customerLastName);
    }

    public List<Address> findAll(){
        String sql = "select STREET, NUMBER, DISTRICT, COUNTRY, CEP, ADDRESS_ID from ADDRESS";

        List<Map<String, Object>> queryReturn = jdbc.queryForList(sql);

        List<Address> allAddress = new ArrayList<>();

        var objectReturn = queryReturn.get(0);
        for (Map<String, Object> map:queryReturn) {
            String street = map.get("STREET").toString();
            var number = ((BigDecimal) map.get("NUMBER")).longValue();
            String district = map.get("DISTRICT").toString();
            String country = map.get("COUNTRY").toString();
            var cep = ((BigDecimal) map.get("CEP")).longValue();
            int id = (Integer) map.get("ADDRESS_ID");
            String customerName = objectReturn.get("c.name").toString();
            String customerLastName = objectReturn.get("c.last_name").toString();
            var address = new Address(id, (int) cep, street, (int) number, district, country, customerName, customerLastName);
            allAddress.add(address);
        }

        return allAddress;
    }

    public Address update(Address address) {

        String sql = new StringBuilder()
                .append("UPDATE ADDRESS SET STREET='")
                .append(address.getStreet())
                .append("', NUMBER= '")
                .append(address.getNumber())
                .append("', DISTRICT= '")
                .append(address.getDistrict())
                .append("', COUNTRY= '")
                .append(address.getCountry())
                .append("', CEP= '")
                .append(address.getCep())
                .append("' WHERE CUSTOMER_ID = ")
                .append(address.getId())
                .toString();

        jdbc.execute(sql);

        return address;
    }


}
