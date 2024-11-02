SELECT * FROM genres
WHERE id = (
    SELECT genre_id
    FROM movies_genres
    GROUP BY genre_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
    );

SELECT * FROM movies
WHERE release_year = (
    SELECT release_year
    FROM movies
    ORDER BY rating DESC
    LIMIT 1
    );

SELECT * FROM movies
WHERE release_year = (
    SELECT release_year
    FROM movies
    GROUP BY release_year
    ORDER BY COUNT(*) DESC
    LIMIT 1
    );