-- TASK 2
-- DDL
CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255),
                       author VARCHAR(255),
                       genre VARCHAR(100),
                       publication_year INTEGER,
                       available BOOLEAN
);

-- DML
INSERT INTO books (title, author, genre, publication_year, available)
VALUES ('Мастер и Маргарита', 'Булгаков М.', 'Роман', 1967, TRUE);

UPDATE books
SET available = FALSE
WHERE id = 3;

DELETE FROM books
WHERE id = 7;