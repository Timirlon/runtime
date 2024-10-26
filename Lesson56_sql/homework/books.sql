-- 1. Создание таблиц
CREATE TABLE genres (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50)
);

CREATE TABLE authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(50)
);

CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50),
                       genre_id INT REFERENCES genres (id),
                       author_id INT REFERENCES authors (id)
);

CREATE TABLE readers (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR (50),
                         surname VARCHAR (50)
);

CREATE TABLE books_readers (
                               book_id INT REFERENCES books (id),
                               reader_id INT REFERENCES readers (id)
);

-- 2. Добавление данных
INSERT INTO genres (name) VALUES ('Детектив'), ('Роман');

INSERT INTO authors (name) VALUES ('Артур Конан Дойл'), ('Лев Толстой');

INSERT INTO books (name, genre_id, author_id) VALUES
                                                  ('Шерлок Холмс', 1, 1),
                                                  ('Война и Мир', 2, 2),
                                                  ('Кавказский пленник', 2, 2);

INSERT INTO readers (name, surname) VALUES ('Дарт', 'Вейдер'), ('Михаил', 'Михалыч');


-- 3.
INSERT INTO books_readers VALUES (1, 1), (2, 1), (2, 2);

-- 4.
SELECT b.name FROM books b
                       JOIN books_readers br ON b.id = br.book_id
WHERE br.reader_id = 1;

-- 5.
SELECT CONCAT(r.name, ' ', r.surname) AS reader_name
FROM readers r
         JOIN books_readers br ON r.id = br.reader_id
WHERE br.book_id = 2;

-- 6.
SELECT b.name, CONCAT(r.name, ' ', r.surname) AS reader
FROM books b
         JOIN books_readers br ON b.id = br.book_id
         JOIN readers r on br.reader_id = r.id
WHERE b.author_id = 2;