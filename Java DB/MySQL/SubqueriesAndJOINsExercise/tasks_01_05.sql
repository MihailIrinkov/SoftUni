-- Employee Address_01

SELECT
    e.employee_id, e.job_title, a.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;


-- Addresses with Towns_02

SELECT
    e.first_name, e.last_name, t.name, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
        JOIN
    towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name , e.last_name
LIMIT 5;


-- Sales Employee_03

SELECT
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS department_name
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    d.name LIKE 'Sales'
ORDER BY e.employee_id DESC;


-- Employee Departments_04

SELECT
    e.employee_id,
    e.first_name,
    salary,
    d.name AS department_name
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;


-- Employees Without Project_05

SELECT
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
WHERE
    project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

