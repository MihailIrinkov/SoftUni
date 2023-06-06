-- Find Names of All Employees by First Name_01
use soft_uni;

SELECT
    first_name, last_name
FROM
    employees
WHERE
    LOWER(first_name) LIKE 'sa%'
ORDER BY employee_id;


SELECT
    first_name, last_name
FROM
    employees
WHERE
    first_name REGEXP '^sa'
ORDER BY employee_id;

-- Find Names of All Employees by Last Name_02

SELECT
    first_name, last_name
FROM
    employees
WHERE
    LOWER(last_name) LIKE '%ei%'
ORDER BY employee_id;

SELECT
    first_name, last_name
FROM
    employees
WHERE
    last_name REGEXP '[ei]'
ORDER BY employee_id;

-- Find First Names of All Employees_03

SELECT
    first_name
FROM
    employees
WHERE
    department_id IN (3 , 10)
        AND YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

-- Find All Employees Except Engineers_04

SELECT
    first_name, last_name
FROM
    employees
WHERE
    lower(job_title) NOT LIKE '%engineer%'
ORDER BY employee_id;

-- Find Towns with Name Length_05

SELECT
    name
FROM
    towns
WHERE
    CHAR_LENGTH(name) IN (5 , 6)
ORDER BY name;

