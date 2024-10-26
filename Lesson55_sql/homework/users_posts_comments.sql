CREATE TABLE users
(
    login VARCHAR(12) PRIMARY KEY,
    bio VARCHAR(255)
);

CREATE TABLE posts
(
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    date TIMESTAMP,
    author VARCHAR(12) NOT NULL,
    FOREIGN KEY (author) REFERENCES users
);

CREATE TABLE comments
(
    text   VARCHAR(255),
    post   INT         NOT NULL,
    FOREIGN KEY (post) REFERENCES posts,
    author VARCHAR(12) NOT NULL,
    FOREIGN KEY (author) REFERENCES users
);


INSERT INTO users VALUES
                      ('Omirkhon', 'Сложно в учении, легко в отчислении☝️'),
                      ('Bekzot', 'existential crisis');


INSERT INTO posts (description, author) VALUES
                                            ('Поел', 'Omirkhon'),
                                            ('Порофлил над Bekzot', 'Omirkhon'),
                                            ('Basics of stalking girls', 'Bekzot');


INSERT INTO comments VALUES
                         ('Ачевсмысле', 2, 'Bekzot'),
                         ('Bro, cringe', 3, 'Omirkhon');


SELECT * FROM posts
                  JOIN comments
                      ON posts.id = comments.post
WHERE comments.author IS NOT NULL;