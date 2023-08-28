-- 15. Get colonists count

DELIMITER $$
CREATE FUNCTION  udf_count_colonists_by_destination_planet (planet_name VARCHAR (30))
RETURNS INT
DETERMINISTIC

BEGIN
DECLARE c_count INT;

SET c_count := (SELECT
    COUNT(tc.colonist_id)
FROM
    travel_cards AS tc
        JOIN
    journeys AS j ON j.id = tc.journey_id
        JOIN
    spaceports AS sp ON sp.id = j.destination_spaceport_id
        JOIN
    planets AS p ON p.id = sp.planet_id
WHERE p.name = planet_name);

RETURN c_count;
END$$

DELIMITER ;

SELECT
    COUNT(tc.colonist_id)
FROM
    travel_cards AS tc
        JOIN
    journeys AS j ON j.id = tc.journey_id
        JOIN
    spaceports AS sp ON sp.id = j.destination_spaceport_id
        JOIN
    planets AS p ON p.id = sp.planet_id
WHERE p.name = 'Otroyphus';

SELECT
    p.name,
    UDF_COUNT_COLONISTS_BY_DESTINATION_PLANET('Otroyphus') AS count
FROM
    planets AS p
WHERE
    p.name = 'Otroyphus';


-- 16. Modify spaceship


DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50),
light_speed_rate_increse INT(11))
BEGIN

IF(SELECT count(ss.name) from spaceships as ss WHERE ss.name = spaceship_name > 0) THEN
UPDATE spaceships
SET light_speed_rate = light_speed_rate + light_speed_rate_increse
WHERE name = spaceship_name;

ELSE
SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
      ROLLBACK;
      END IF;

END
DELIMITER ;