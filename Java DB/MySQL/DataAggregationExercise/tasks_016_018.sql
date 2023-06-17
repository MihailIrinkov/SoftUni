-- 3rd Highest Salary*_016

SELECT DISTINCT
    department_id,
    (SELECT DISTINCT
            salary
        FROM
            employees AS e1
        WHERE
            e1.department_id = employees.department_id
        ORDER BY salary DESC
        LIMIT 1 OFFSET 2) AS 'third_highest_salary'
FROM
    employees
HAVING `third_highest_salary` IS NOT NULL
ORDER BY department_id;

-- Salary Challenge**_017

SELECT
    first_name, last_name, department_id
FROM
    employees AS e1
WHERE
    salary > (SELECT
            AVG(salary)
        FROM
            employees AS e2
        WHERE
            e1.department_id = e2.department_id)
ORDER BY department_id , employee_id
LIMIT 10;

-- Departments Total Salaries_018

SELECT
    department_id, SUM(salary) AS 'total_salary'
FROM
    employees
GROUP BY department_id
ORDER BY department_id;

