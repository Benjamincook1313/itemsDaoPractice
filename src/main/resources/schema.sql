CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    name varchar(50),
    price DECIMAL(5,2),
    quantity int,
    description VARCHAR(256)
);

INSERT INTO items(name, price, quantity, description)
VALUES('Apples', 2.25, 12, 'Honey Crisp'),
('Grapes', 2.50, 1, 'Concord');