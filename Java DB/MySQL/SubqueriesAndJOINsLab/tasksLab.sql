-- Managers_01

SELECT
    e.employee_id,
    CONCAT(first_name, ' ', last_name) AS 'full_name',
    d.department_id,
    d.name AS department_name
FROM
    departments AS d
        JOIN
    employees AS e ON d.manager_id = e.employee_id
ORDER BY employee_id
LIMIT 5;

-- Towns Addresses_02

SELECT
    t.town_id, t.name AS town_name, a.address_text
FROM
    towns AS t
        JOIN
    addresses AS a ON t.town_id = a.town_id
WHERE
    name IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY town_id , address_id;


-- Employees Without Managers_03

SELECT
    employee_id, first_name, last_name, department_id, salary
FROM
    employees
WHERE
    manager_id IS NULL;

-- Higher Salary_04

SELECT
    COUNT(*)
FROM
    employees
WHERE
    salary > (SELECT
            AVG(salary)
        FROM
            employees);