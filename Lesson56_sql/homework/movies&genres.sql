-- 1.
SELECT g.name, COUNT(*) FROM genres g
                                 JOIN movies_genres mg ON g.id = mg.genre_id
                                 JOIN movies m ON mg.movie_id = m.id
GROUP BY g.name
ORDER BY COUNT(*) DESC LIMIT 5;

-- 2.
SELECT g.name, AVG(m.rating) AS avg_rating
FROM genres g
         JOIN movies_genres mg ON g.id = mg.genre_id
         JOIN movies m ON mg.movie_id = m.id
GROUP BY g.name
ORDER BY avg_rating DESC;

-- 3.
SELECT release_year, MAX(rating) AS max_rating
FROM movies
GROUP BY release_year
ORDER BY release_year;

-- 4.
SELECT m.release_year, g.name, COUNT(*) FROM movies m
                                                 JOIN movies_genres mg ON m.id = mg.movie_id
                                                 JOIN genres g ON mg.genre_id = g.id
GROUP BY m.release_year, g.name
ORDER BY COUNT(*) DESC;

-- 5.
SELECT g.name FROM genres g
                       JOIN movies_genres mg ON g.id = mg.genre_id
                       JOIN movies m ON mg.movie_id = m.id
GROUP BY g.name
HAVING COUNT(*) > 5;

-- 6.
SELECT release_year, COUNT(*) AS movie_count, AVG(rating) AS avg_rating
FROM movies
GROUP BY release_year
ORDER BY avg_rating DESC;

-- 7.
SELECT m.title, m.release_year, m.rating FROM movies m
                                                  JOIN movies_genres mg ON m.id = mg.movie_id
                                                  JOIN genres g ON mg.genre_id = g.id
WHERE g.name = 'Боевик' AND m.rating > 8;

-- 8.
SELECT title, rating FROM movies
WHERE rating = (
    SELECT MAX(rating) FROM movies
)
   OR rating = (
    SELECT MIN(rating) FROM movies
);