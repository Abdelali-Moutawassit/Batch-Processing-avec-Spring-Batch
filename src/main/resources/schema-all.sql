DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
                        id BIGINT IDENTITY NOT NULL PRIMARY KEY,
                        order_id BIGINT,
                        customer_name VARCHAR(100),
                        amount DOUBLE
);