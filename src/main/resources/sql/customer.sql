create table CUSTOMER (
	CUSTOMER_ID SERIAL primary key,
	NAME VARCHAR(50),
	LAST_NAME VARCHAR(100),
	CPF NUMERIC(11, 0)
)