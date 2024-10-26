-- 1
SELECT * FROM continents;

-- 2
SELECT * FROM countries;

-- 3
SELECT * FROM cities;

-- 4
SELECT name, population FROM cities;

-- 5
SELECT name, population FROM cities
WHERE population > 5000000;

-- 6
SELECT name, population FROM cities
WHERE name LIKE 'А%';

-- 7
SELECT name, population FROM cities
WHERE name LIKE 'А%'
ORDER BY name;

-- 8
SELECT name, population FROM cities
WHERE CHAR_LENGTH(name) >= 7;

-- 9
SELECT name, population FROM cities
WHERE CHAR_LENGTH(name) >= 7
ORDER BY population DESC;

-- 10
SELECT cities.name, cities.population FROM cities
                                               JOIN countries ON cities.country_id = countries.id
WHERE countries.name = 'Казахстан';

-- 11
SELECT countries.name FROM countries
                               JOIN continents ON countries.continent_id = continents.id
WHERE continents.name = 'Европа';

-- 12
SELECT countries.name FROM countries
                               JOIN continents ON countries.continent_id = continents.id
WHERE continents.name = 'Европа' OR
    continents.name = 'Азия';

-- 13
SELECT countries.name FROM countries
                               JOIN continents ON countries.continent_id = continents.id
WHERE (NOT continents.name = 'Европа') OR
    (NOT continents.name = 'Азия');

-- 14
SELECT name, population FROM cities
ORDER BY population ASC;

-- 15
SELECT cities.name, cities.population FROM cities
                                               JOIN countries ON cities.country_id = countries.id
WHERE countries.name = 'Германия'
ORDER BY cities.population ASC;

-- 16
SELECT cities.name, cities.population FROM cities
                                               JOIN countries ON cities.country_id = countries.id
WHERE countries.name = 'Россия'
ORDER BY cities.name ASC;

-- 17
SELECT cities.name, cities.population FROM cities
                                               JOIN countries ON cities.country_id = countries.id
WHERE countries.name = 'Англия'
  AND cities.population > 750000;

-- 18
SELECT c.name, c.population FROM cities c
                                     JOIN countries ctr ON c.country_id = ctr.id
WHERE ctr.name = 'Франция'
   OR ctr.name = 'Италия'
   OR ctr.name = 'Россия';

-- 19
SELECT SUM(c.population) AS total_population
FROM cities c
         JOIN countries ctr ON c.country_id = ctr.id
WHERE ctr.name = 'Германия';

-- 20
SELECT SUM(c.population) AS total_population
FROM cities c
         JOIN countries ctr ON c.country_id = ctr.id
         JOIN continents cont on ctr.continent_id = cont.id
WHERE cont.name = 'Европа';