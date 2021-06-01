CREATE TABLE seller (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR
);

CREATE TABLE customer(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR
);

CREATE TABLE publication(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    date_of_publication DATE,
    seller_id INTEGER NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES seller(id)
);

CREATE TABLE seller_customer (
    seller_id INTEGER NOT NULL,
    customer_id INTEGER NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES seller(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    PRIMARY KEY (seller_id, customer_id)
);