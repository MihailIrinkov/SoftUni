-- Departments Info_01

SELECT
    department_id, COUNT(*)
FROM
    employees
GROUP BY department_id
ORDER BY department_id;

-- Average Salary_02

SELECT
    department_id, ROUND(AVG(salary), 2)
FROM
    employees
GROUP BY department_id
ORDER BY department_id;

-- Min Salary_03

SELECT
    department_id, MIN(salary) AS 'Min Salary'
FROM
    employees
GROUP BY department_id
HAVING `Min Salary` > 800;

-- Appetizers Count_04

SELECT
    COUNT(category_id)
FROM
    products
WHERE
    category_id = 2 AND price > 8;

-- Menu Prices_05

SELECT
    category_id,
    ROUND(AVG(price), 2) AS 'Average Price',
    ROUND(MIN(price), 2) AS 'Cheapest Product',
    ROUND(MAX(price), 2) AS 'Most Expensive Product'
FROM
    products
GROUP BY category_id;

