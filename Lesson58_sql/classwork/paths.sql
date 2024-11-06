CREATE TABLE paths (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50),
                       created_at TIMESTAMP,
                       parent_directory INT REFERENCES paths (id)
);

INSERT INTO paths (name, created_at) VALUES ('home', now());

INSERT INTO paths (name, created_at, parent_directory)
VALUES ('folder', now(), 1);

INSERT INTO paths (name, created_at, parent_directory)
VALUES ('file.txt', now(), 2),
       ('file2.txt', now(), 2),
       ('subfolder', now(), 2);


SELECT main.name, COUNT(sub.parent_directory) AS child_count
FROM paths main


SELECT main.name, COUNT(sub.parent_directory) AS child_count
FROM paths main
         LEFT JOIN paths sub ON main.id = sub.parent_directory
GROUP BY main.name