
-- 5.	Employees

SELECT
    first_name, last_name, age, salary, happiness_level
FROM
    employees
ORDER BY salary , id;


-- 6. Addresses of the teams

SELECT
    t.name,
    a.name AS address_name,
    CHAR_LENGTH(a.name) AS count_of_characters
FROM
    teams AS t
        JOIN
    offices AS o ON o.id = t.office_id
        JOIN
    addresses AS a ON a.id = o.address_id
WHERE
    o.website IS NOT NULL
ORDER BY t.name , a.name;

-- 7. Categories Info

SELECT
    c.name,
    COUNT(gc.category_id) AS games_count,
    ROUND(AVG(g.budget), 2) AS avg_budget,
    MAX(g.rating) AS max_rating
FROM
    categories AS c
        JOIN
    games_categories AS gc ON c.id = gc.category_id
        JOIN
    games AS g ON gc.game_id = g.id

GROUP BY c.name
HAVING max_rating >= 9.5
ORDER BY games_count DESC , c.name;


-- 8.	Games of 2022

SELECT
    g.name,
    g.release_date,
    CONCAT(LEFT(g.description, 10), '...') AS summary,
    CASE
        WHEN MONTH(g.release_date) <= 3 THEN 'Q1'
        WHEN MONTH(g.release_date) <= 6 THEN 'Q2'
        WHEN MONTH(g.release_date) <= 9 THEN 'Q3'
        WHEN MONTH(g.release_date) <= 12 THEN 'Q4'
    END AS quarter,
    t.name AS team_name
FROM
    games AS g
        JOIN
    teams AS t ON g.team_id = t.id
WHERE
    YEAR(g.release_date) = '2022'
        AND MONTH(g.release_date) % 2 = 0
        AND g.name LIKE '%2'
ORDER BY quarter;


-- 9.	Full info for games

SELECT
    g.name,
    IF(g.budget < 50000,
        'Normal budget',
        'Insufficient budget') AS budget_level,
    t.name AS team_name,
    a.name
FROM
    games AS g
        LEFT JOIN
    games_categories AS gc ON g.id = gc.game_id
        JOIN
    teams AS t ON g.team_id = t.id
        JOIN
    offices AS o ON t.office_id = o.id
        JOIN
    addresses AS a ON o.address_id = a.id
WHERE
    g.release_date IS NULL
        AND gc.category_id IS NULL
ORDER BY g.name;