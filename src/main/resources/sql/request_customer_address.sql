select * from address a
inner join customer_address ca on a.address_id = ca.address_id
where ca.customer_id