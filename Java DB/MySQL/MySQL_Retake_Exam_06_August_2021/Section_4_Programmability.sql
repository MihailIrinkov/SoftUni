-- 10.	Find all basic information for a game

DELIMITER $$

CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS TEXT
DETERMINISTIC
BEGIN
DECLARE result TEXT;
SET result :=
(SELECT
    CONCAT_WS(' ',
            'The',
            g.name,
            'is developed by a',
            t.name,
            'in an office with an address',
            a.name) AS info
FROM
    teams AS t
        JOIN
    games AS g ON t.id = g.team_id
        JOIN
    offices AS o ON t.office_id = o.id
        JOIN
    addresses AS a ON o.address_id = a.id
WHERE
    g.name = game_name);
    RETURN result;
END$$

DELIMITER ;

SELECT
    CONCAT_WS(' ',
            'The',
            g.name,
            'is developed by a',
            t.name,
            'in an office with an address',
            a.name) AS info
FROM
    teams AS t
        JOIN
    games AS g ON t.id = g.team_id
        JOIN
    offices AS o ON t.office_id = o.id
        JOIN
    addresses AS a ON o.address_id = a.id
WHERE
    g.name = 'Bitwolf';

SELECT udf_game_info_by_name('Job') AS info;


-- 11.	Update budget of the games

DELIMITER $$
CREATE PROCEDURE udp_update_budget(min_game_rating INT)
BEGIN
UPDATE games as g
LEFT JOIN games_categories as gc ON g.id = gc.game_id

SET g.budget = g.budget + 100000, g.release_date = g.release_date + INTERVAL 1 YEAR

WHERE g.release_date IS NOT NULL AND g.rating > min_game_rating AND gc.game_id is NULL;
END $$

DELIMITER ;


UPDATE games as g
JOIN games_categories as gc ON g.id = gc.game_id
RIGHT JOIN categories as c ON gc.category_id = c.id
SET g.budget = g.budget + 100000 AND g.release_date = year(g.release_date) + 1

WHERE g.release_date IS NOT NULL AND g.rating > min_game_rating;

SELECT *
FROM games as g
JOIN games_categories as gc ON g.id = gc.game_id
JOIN categories as c ON gc.category_id = c.id
WHERE g.name = 'Quo Lux';

SELECT *
FROM games_categories as gc
JOIN categories as c ON gc.category_id = c.id;

update  games
set release_date = release_date + INTERVAL 1 YEAR
WHERE name = 'Asoka';


SELECT *
FROM games
WHERE name = 'Quo Lux';

SELECT *
FROM
games as g
LEFT JOIN games_categories as gc ON g.id = gc.game_id



WHERE g.release_date IS NOT NULL AND g.rating > 8 AND gc.category_id is NULL;