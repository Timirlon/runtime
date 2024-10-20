-- TASK 1
CREATE TABLE movie (
                       id              SERIAL PRIMARY KEY,  -- Уникальный идентификатор фильма
                       title           VARCHAR(255) NOT NULL, -- Название фильма
                       rental_rate     DECIMAL(4,2) NOT NULL, -- Стоимость аренды
                       rental_duration INTEGER NOT NULL,     -- Длительность аренды (в днях)
                       rating          VARCHAR(10) NOT NULL  -- Рейтинг фильма (например, 'PG', 'PG-13', 'R')
);

INSERT INTO movie (title, rental_rate, rental_duration, rating)
VALUES ('The Godfather', 2.99, 7, 'R'),
       ('Casablanca', 1.99, 5, 'PG'),
       ('The Silence of the Lambs', 3.49, 4, 'R'),
       ('Jurassic Park', 2.49, 5, 'PG-13'),
       ('The Matrix', 2.99, 4, 'R'),
       ('Spirited Away', 1.99, 6, 'PG'),
       ('Saving Private Ryan', 3.99, 6, 'R'),
       ('The Lion King', 2.49, 4, 'G'),
       ('Back to the Future', 2.99, 5, 'PG'),
       ('Toy Story', 2.49, 4, 'G');

-- 1
SELECT * FROM movie
WHERE (rating = 'R' OR rating = 'NC-17') AND rental_rate < '3';

-- 2
SELECT title FROM movie
WHERE rating = 'G' OR rental_rate > 4 OR rental_duration > 5;

-- 3
SELECT * FROM movie
WHERE rental_rate BETWEEN 3 AND 5
  AND rating != 'PG';

-- 4
SELECT title FROM movie
WHERE rating != 'PG-13'
AND rental_rate < 2.5;

-- 5
SELECT * FROM movie
WHERE rating = 'R'
  AND rental_duration >= 7
  AND rental_rate BETWEEN 1.5 AND 3;

-- 6
SELECT * FROM movie
WHERE rating != 'G'
AND rating != 'PG-13'
AND rental_duration = 5;