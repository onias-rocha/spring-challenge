
CREATE TABLE seller (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR
);

CREATE TABLE customer(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR
);

CREATE TABLE product (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    type VARCHAR(255),
    brand VARCHAR(255),
    color VARCHAR(255),
    notes VARCHAR(255),
    seller_id INTEGER,
    FOREIGN KEY (seller_id) REFERENCES seller(id)
);

CREATE TABLE seller_customer (
    seller_id INTEGER NOT NULL,
    customer_id INTEGER NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES seller(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    PRIMARY KEY (seller_id, customer_id)
);

CREATE TABLE publication(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    date_of_publication DATE,
    category INTEGER,
    price DOUBLE,
    has_promo BOOLEAN DEFAULT FALSE,
    discount DOUBLE DEFAULT 0.0,
    product_id INTEGER,
    seller_id INTEGER,
    FOREIGN KEY (seller_id) REFERENCES seller(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

