CREATE TABLE services (
    id_service CHAR(36) PRIMARY KEY,
    name_service VARCHAR(100) NOT NULL,
    duration_min_service INT NOT NULL,
    price_service DECIMAL(10, 2) NOT NULL,
    active_service BOOLEAN NOT NULL DEFAULT TRUE
);