CREATE TABLE departments
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE employees
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    department_id INTEGER REFERENCES departments (id)
);

CREATE TABLE projects
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    department_id INTEGER REFERENCES departments (id)
);

CREATE TABLE tasks
(
    id                   SERIAL PRIMARY KEY,
    name                 VARCHAR(100) NOT NULL,
    project_id           INTEGER REFERENCES projects (id),
    assigned_employee_id INTEGER REFERENCES employees (id)
);

CREATE TABLE employee_projects
(
    employee_id INTEGER REFERENCES employees (id),
    project_id  INTEGER REFERENCES projects (id),
    PRIMARY KEY (employee_id, project_id)
);


INSERT INTO departments (name)
VALUES ('Отдел разработки'), -- 1
       ('Отдел маркетинга'),  -- 2
       ('Отдел продаж'),  -- 3
       ('Отдел кадров'); -- Отдел без сотрудников


INSERT INTO employees (name, department_id)
VALUES ('Иван Иванов', 1),
       ('Петр Петров', 1),
       ('Мария Сидорова', 2),
       ('Анна Кузнецова', 3);
-- Отдел кадров (id = 4) без сотрудников

INSERT INTO projects (name, department_id)
VALUES ('Проект А', 1),
       ('Проект B', 1),
       ('Проект C', 2),
       ('Проект D', 4); -- Проект в отделе без сотрудников

INSERT INTO tasks (name, project_id, assigned_employee_id)
VALUES ('Задача 1', 1, 1),
       ('Задача 2', 1, 2),
       ('Задача 3', 2, NULL), -- Задача без назначенного сотрудника
       ('Задача 4', 3, 3),
       ('Задача 5', 4, NULL); -- Задача в проекте из отдела без сотрудников


INSERT INTO employee_projects (employee_id, project_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 3);
-- Проект D (id = 4) без сотрудников
