-- 2.	Insert

INSERT INTO games(name, rating, budget, team_id)
SELECT lower(reverse(substring(t.name, 2))), t.id, leader_id * 1000, t.id
FROM teams as t
WHERE t.id BETWEEN 1 AND 9;

-- 3.	Update

UPDATE employees
SET
    salary = salary + 1000
WHERE
    age <= 39 AND salary < 4999;


-- 4.	Delete

DELETE g FROM games AS g
        LEFT JOIN
    games_categories AS gc ON g.id = gc.game_id
WHERE
    g.release_date IS NULL
    AND gc.category_id IS NULL;

