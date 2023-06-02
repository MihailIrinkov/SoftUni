SELECT
    *
FROM
    departments
ORDER BY department_id;

-- Find all Department Names_02

SELECT
    name
FROM
    departments
ORDER BY department_id;

-- Find salary of Each Employee_03

SELECT
    first_name, last_name, salary
FROM
    employees
ORDER BY employee_id;

-- Find Full Name of Each Employee_04

SELECT
    first_name, middle_name, last_name
FROM
    employees
ORDER BY employee_id;

-- Find Email Address of Each Employee_05

SELECT
    CONCAT(first_name,
            '.',
            last_name,
            '@softuni.bg') AS 'full_ email_address'
FROM
    employees;

 -- Find All Different Employee's Salaries_06;
 SELECT DISTINCT
    salary
FROM
    employees;

-- Find all Information About Employees_07
SELECT
    *
FROM
    employees
WHERE
    job_title = 'Sales Representative';

-- Find all Information About Employees_07
SELECT
    *
FROM
    employees
WHERE
    job_title = 'Sales Representative';

-- Find Names of All Employees by salary in Range_08
SELECT
    first_name, last_name, job_title
FROM
    employees
WHERE
    salary BETWEEN 20000 AND 30000
ORDER BY employee_id;

-- Find Names of All Employees_09
SELECT
    CONCAT_WS(' ', first_name, middle_name, last_name) AS 'Full Name'
FROM
    employees
WHERE
    salary IN (25000 , 14000, 12500, 23600);
--SELECT
--    CONCAT_WS(' ', first_name, middle_name, last_name) AS 'Full Name'
--FROM
--    employees
--WHERE
--    salary = 25000 OR salary = 14000
--        OR salary = 12500
--        OR salary = 23600;

SELECT
    first_name, last_name
FROM
    employees
WHERE
    manager_id IS NULL;
