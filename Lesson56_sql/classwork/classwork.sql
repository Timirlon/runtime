CREATE TABLE films (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50)
);

CREATE TABLE actors (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50)
);

CREATE TABLE directors(
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(50)
);

CREATE TABLE films_actors (
                              film_id INT REFERENCES films (id),
                              actor_id INT REFERENCES actors (id),
                              PRIMARY KEY (film_id, actor_id)
);

CREATE TABLE films_directors (
                                 film_id INT REFERENCES films (id),
                                 actor_id INT REFERENCES directors (id),
                                 PRIMARY KEY (film_id, actor_id)
);

INSERT INTO films VALUES (1, 'Мститель-мены');
INSERT INTO directors VALUES (1, 'Энтони Руссо'), (2, 'Джозеф Руссо');
INSERT INTO actors VALUES (1, 'Роберт Дауни Мл.'), (2, 'Крис Эванс'), (3, 'Скарлетт Йохансон');

INSERT INTO films_actors VALUES (1, 1), (1, 2), (1, 3);
INSERT INTO films_directors VALUES (1, 1), (1, 2);