-- 02.	Insert

INSERT INTO actors (first_name, last_name, birthdate, height, awards, country_id)
SELECT reverse(first_name),
reverse(last_name),
DATE (birthdate - 2),
height + 10,
country_id,
3
FROM actors
WHERE id <= 10;

-- 03.	Update

UPDATE movies_additional_info
SET
    runtime = runtime - 10
WHERE
    id BETWEEN 15 AND 25;

-- 04.	Delete

DELETE c FROM countries AS c
        LEFT JOIN
    movies AS m ON c.id = m.country_id
WHERE
    m.country_id IS NULL;

