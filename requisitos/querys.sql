-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE 'seller_customer' (
    seller_id int(11) NOT NULL,
    customer_id int(11) NOT NULL,

    PRIMARY KEY (seller_id, customer_id),
    FOREIGN KEY (seller_id) references seller(id)
    FOREIGN KEY (customer_id) references customer(id)
);