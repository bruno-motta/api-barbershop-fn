create table customer(
    id CHAR(36) PRIMARY KEY,
    name_customer VARCHAR(100) NOT NULL,
    email_customer VARCHAR(100) NOT NULL,
    telephone_customer VARCHAR(15) NOT NULL,
    dataTimeRegistration TIMESTAMP NOT NULL

)