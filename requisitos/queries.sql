-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE 'seller_customer' (
    seller_id int(11) NOT NULL,
    customer_id int(11) NOT NULL,

    PRIMARY KEY (seller_id, customer_id),
    FOREIGN KEY (seller_id) references seller(id),
    FOREIGN KEY (customer_id) references customer(id)
);

INSERT INTO seller (nome) VALUES ('Casas Bahia');
INSERT INTO seller (nome) VALUES ('Lojinha do Franciso');
INSERT INTO seller (nome) VALUES ('DBTech Informatica');
INSERT INTO seller (nome) VALUES ('Ponto');
INSERT INTO seller (nome) VALUES ('Americanas');

INSERT INTO customer (nome) VALUES ('Onias da Rocha Filho');
INSERT INTO customer (nome) VALUES ('Jéssica Milena');

INSERT INTO seller_customer (seller_id, customer_id) values (1,4);
INSERT INTO seller_customer (seller_id, customer_id) values (1,2);
INSERT INTO seller_customer (seller_id, customer_id) values (2,2);
INSERT INTO seller_customer (seller_id, customer_id) values (2,5);


select customer.nome, seller.nome from seller, customer, seller_customer where seller.id = seller_customer.seller_id;

select customer.nome, seller.nome from seller, customer, seller_customer where seller.id = seller_customer.seller_id order by customer.id, seller.nome