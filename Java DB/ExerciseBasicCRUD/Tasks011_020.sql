-- Find All Employees with salary More Than 50000_011

SELECT
    first_name, last_name, salary
FROM
    employees
WHERE
    salary > 50000
ORDER BY salary DESC;

-- Find 5 Best Paid Employees_012

SELECT
    first_name, last_name
FROM
    employees
ORDER BY salary DESC
LIMIT 5;

-- Find All Employees Except Marketing_013

SELECT
    first_name, last_name
FROM
    employees
WHERE
    department_id != 4;

-- Sort Employees Table_014

SELECT
    *
FROM
    employees
ORDER BY salary DESC , first_name , last_name DESC , middle_name;

-- Create View Employees with Salaries_015

CREATE VIEW v_employees_salaries AS
    SELECT
        first_name, last_name, salary
    FROM
        employees;

-- Create View Employees with Job Titles_016

CREATE VIEW v_employees_job_titles AS
    SELECT
        CONCAT_WS(' ', first_name, middle_name, last_name) AS 'full_name',
        job_title
    FROM
        employees;

-- Distinct Job Titles_017

SELECT DISTINCT
    job_title
FROM
    employees
ORDER BY job_title
LIMIT 5;

-- Find First 10 Started Projects_018

SELECT
    *
FROM
    projects
ORDER BY start_date , name
LIMIT 10;

-- Last 7 Hired Employees_019

SELECT
    first_name, last_name, hire_date
FROM
    employees
ORDER BY hire_date DESC
LIMIT 7;

-- Increase Salaries_020

UPDATE employees
SET
    salary = salary * 1.12
WHERE
    department_id IN (1 , 2, 4, 11);
SELECT
    salary
FROM
    employees;