create table product_request(
	request_id int,
	product_id int,
	quantity numeric(12,0),
	constraint fk_product
	foreign key(product_id)
	references product(product_id),
	constraint fk_request
	foreign key(request_id)
	references request(request_id)
	);