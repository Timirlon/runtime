SELECT m.title
FROM movies m
         JOIN movies_genres mg ON m.id = mg.movie_id
GROUP BY m.title, mg.movie_id
HAVING COUNT(*) > (
    SELECT AVG(count)
    FROM (SELECT COUNT(*) AS count FROM movies_genres GROUP BY movie_id) AS temp_table
);


WITH movie_genre_count AS
         (SELECT m.title, COUNT(*) AS genre_count
          FROM movies m
                   JOIN movies_genres mg ON m.id = mg.movie_id
          WHERE title = 'Тёмный Рыцарь'
          GROUP BY m.title)
SELECT m.title FROM movies m
                        JOIN movies_genres mg ON m.id = mg.movie_id
GROUP BY m.id
HAVING COUNT(*) >= (SELECT genre_count FROM movie_genre_count);