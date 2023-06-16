-- Average Interest_011

SELECT
    deposit_group,
    is_deposit_expired,
    AVG(deposit_interest) AS 'average_interest'
FROM
    wizzard_deposits
WHERE
    deposit_start_date > '1985-01-01'
GROUP BY deposit_group , is_deposit_expired
ORDER BY deposit_group DESC , is_deposit_expired ASC;

use soft_uni;

-- Employees Minimum Salaries_012

SELECT
    department_id, MIN(salary) AS 'minimum_salary'
FROM
    employees
WHERE
    hire_date > '2000-01-01'
GROUP BY department_id
HAVING department_id IN (2 , 5, 7)
ORDER BY department_id ASC;


SELECT
    department_id, MIN(salary) AS 'minimum_salary'
FROM
    employees
WHERE
    hire_date > '2000-01-01'
        AND department_id IN (2 , 5, 7)
GROUP BY department_id
ORDER BY department_id ASC;

-- Employees Average Salaries_013

CREATE TABLE max_salary AS SELECT * FROM
    employees
WHERE
    salary > 30000;


SET SQL_SAFE_UPDATES = 0;
DELETE FROM max_salary
WHERE
    manager_id = 42;

UPDATE max_salary
SET
    salary = salary + 5000
WHERE
    department_id = 1;

SELECT
    department_id, AVG(salary)
FROM
    max_salary
GROUP BY department_id
ORDER BY department_id ASC;

-- Employees Maximum Salaries_014

SELECT
    department_id, MAX(salary) AS max_salary
FROM
    employees
GROUP BY department_id
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY department_id ASC;

-- Employees Count Salaries_015

SELECT
    COUNT(*) AS ''
FROM
    employees
WHERE
    manager_id IS NULL;