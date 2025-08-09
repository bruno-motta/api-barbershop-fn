CREATE TABLE services (
    id_product CHAR(36) PRIMARY KEY,
    name_product VARCHAR(100) NOT NULL,
    duration_min_product INT NOT NULL,
    price_product DECIMAL(10, 2) NOT NULL,
    active_product BOOLEAN NOT NULL DEFAULT TRUE
);