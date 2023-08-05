-- 05.	Countries

SELECT
    id, name, continent, currency
FROM
    countries
ORDER BY currency DESC , id;


-- 06.	Old movies

SELECT
    m.id, m.title, a.runtime, a.budget, a.release_date
FROM
    movies AS m
        JOIN
    movies_additional_info AS a ON a.id = m.id
WHERE
    YEAR(a.release_date) BETWEEN 1996 AND 1999
ORDER BY a.runtime , id
LIMIT 20;


-- 07.	Movie casting

SELECT
    CONCAT(a.first_name, ' ', a.last_name) AS full_name,
    CONCAT(REVERSE(a.last_name),
            CHAR_LENGTH(last_name),
            '@cast.com') AS email,
    (2022 - YEAR(a.birthdate)) AS age,
    height
FROM
    actors AS a
        LEFT JOIN
    movies_actors AS m ON a.id = m.actor_id
WHERE
    m.movie_id IS NULL
ORDER BY height;


-- 08.	International festival

SELECT
    c.name, COUNT(m.country_id)
FROM
    countries AS c
        JOIN
    movies AS m ON c.id = m.country_id
GROUP BY m.country_id
HAVING COUNT(m.country_id) >= 7
ORDER BY c.name DESC;

-- 09.	Rating system

SELECT
    m.title,
    IF(ma.rating <= 4,
        'poor',
        IF(ma.rating <= 7, 'good', 'excellent')) AS rating,
    IF(ma.has_subtitles = 1, 'english', '-') AS subtitles,
    ma.budget
FROM
    movies AS m
        JOIN
    movies_additional_info AS ma ON m.id = ma.id
ORDER BY budget DESC;