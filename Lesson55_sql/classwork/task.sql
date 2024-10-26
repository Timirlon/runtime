CREATE DATABASE world;

SELECT AVG(surfacearea) FROM country
WHERE governmentform = 'Republic';

SELECT SUM(population) FROM country
WHERE lifeexpectancy > 75;

SELECT MAX(gnp) FROM country
WHERE indepyear > 1950;

SELECT MIN(gnpold) FROM country
WHERE continent = 'Europe';

SELECT COUNT(*) FROM country
WHERE continent = 'Africa'
  AND headofstate IS NULL;