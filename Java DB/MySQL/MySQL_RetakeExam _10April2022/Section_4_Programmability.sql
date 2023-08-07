-- 10.	History movies

DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE position_space INT;
SET position_space = LOCATE(' ', full_name);

RETURN(
SELECT count(g.name)
    -- CONCAT_WS(' ', a.first_name, a.last_name) AS full_name
FROM
    actors AS a
        JOIN
    movies_actors AS ma ON a.id = ma.actor_id
        JOIN
    genres_movies AS gm ON ma.movie_id = gm.movie_id
        JOIN
    genres AS g ON gm.genre_id = g.id
WHERE
    g.name = 'History'
        AND concat(a.first_name, ' ', a.last_name) = full_name);


END$$

DELIMITER ;

SELECT
    COUNT(*) AS history_movies,
    CONCAT_WS(' ', a.first_name, a.last_name) AS full_name
FROM
    actors AS a
        JOIN
    movies_actors AS ma ON a.id = ma.actor_id
        JOIN
    genres_movies AS gm ON ma.movie_id = gm.movie_id
        JOIN
    genres AS g ON gm.genre_id = g.id
WHERE
    g.name = 'History'
        AND a.first_name = 'Stephan'
        AND a.last_name = 'Lundberg';

SELECT UDF_ACTOR_HISTORY_MOVIES_COUNT('Stephan Lundberg') AS 'history_movies';

SELECT UDF_ACTOR_HISTORY_MOVIES_COUNT('Jared Di Batista') AS 'history_movies';


-- 11.	Movie awards

DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))

BEGIN
 UPDATE
    actors AS a
        JOIN
    movies_actors AS ma ON a.id = ma.actor_id
        JOIN
    movies AS m ON m.id = ma.movie_id
    SET a.awards = a.awards + 1
WHERE
    m.title = movie_title;
END$$

DELIMITER ;

CALL udp_award_movie('Tea For Two');
CALL udp_award_movie('Miss You Can Do It');