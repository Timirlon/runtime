CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50)
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(50),
                          price DOUBLE PRECISION,
                          category_id INT REFERENCES categories (id)
);

CREATE TABLE options (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(50),
                         category_id INT REFERENCES categories (id)
);

CREATE TABLE values (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        product_id INT REFERENCES products (id),
                        option_id INT REFERENCES options (id)
);

INSERT INTO categories (name) VALUES ('Процессоры'), ('Мониторы');

INSERT INTO products (name, price, category_id)
VALUES ('Intel Core I9 9900', 324.99, 1),
       ('AMD Ryzen R7 7700', 279.99, 1),
       ('Samsung SU556270', 499.99, 2),
       ('AOC Z215S659', 549.99, 2);

INSERT INTO options (name, category_id)
VALUES ('Производитель', 1),
       ('Количество ядер', 1),
       ('Сокет', 1),
       ('Производитель', 2),
       ('Диагональ', 2),
       ('Матрица', 2),
       ('Разрешение', 2);

INSERT INTO values (name, product_id, option_id)
VALUES ('Intel', 1, 1),
       ('8', 1, 2),
       ('1250', 1, 3),
       ('AMD', 2, 1),
       ('12', 2, 2),
       ('AM4', 2, 3),
       ('Samsung', 3, 4),
       ('27', 3, 5),
       ('TN', 3, 6),
       ('2560x1440', 3, 7),
       ('AOC', 4, 4),
       ('21.5', 4, 5),
       ('AH-IPS', 4, 6),
       ('1920x1080', 4, 7);