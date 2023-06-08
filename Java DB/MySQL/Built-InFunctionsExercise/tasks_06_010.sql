-- Find Towns Starting With_06

SELECT
    town_id, name
FROM
    towns
WHERE
    UPPER(name) REGEXP '^[M K B E]'
ORDER BY name;

SELECT
    town_id, name
FROM
    towns
WHERE
    UPPER(LEFT(name, 1)) IN ('M' , 'K', 'B', 'E')
ORDER BY name;

SELECT
    *
FROM
    towns
WHERE
    LOWER(name) LIKE 'm%'
        OR LOWER(name) LIKE 'k%'
        OR LOWER(name) LIKE 'b%'
        OR LOWER(name) LIKE 'e%'
ORDER BY name;

-- Find Towns Not Starting With_07

SELECT
    *
FROM
    towns
WHERE
    LOWER(LEFT(name, 1)) NOT IN ('r' , 'b', 'd')
ORDER BY name;

SELECT
    *
FROM
    towns
WHERE
    name REGEXP '^[^rRbBdD]'
ORDER BY name;

-- Create View Employees Hired After 2000 Year_08

CREATE VIEW v_employees_hired_after_2000 AS
    SELECT
        first_name, last_name
    FROM
        employees
    WHERE
        YEAR(hire_date) > 2000;

-- Length of Last Name_09

SELECT
    first_name, last_name
FROM
    employees
WHERE
    CHAR_LENGTH(last_name) = 5;


-- Countries Holding 'A' 3 or More Times_010

SELECT
    country_name, iso_code
FROM
    countries
WHERE
    country_name LIKE '%a%a%a%'
ORDER BY iso_code;

SELECT
    country_name, iso_code
FROM
    countries
WHERE
    (CHAR_LENGTH(country_name) - CHAR_LENGTH(REPLACE(LOWER(country_name), 'a', ''))) >= 3
ORDER BY iso_code;

