-- 04. Extract all travel cards

SELECT
    card_number, job_during_journey
FROM
    travel_cards
ORDER BY card_number;

-- 05. Extract all colonists

SELECT
    id, CONCAT(first_name, ' ', last_name) AS full_name, ucn
FROM
    colonists
ORDER BY first_name , last_name , id;

-- 06.	Extract all military journeys

SELECT
    id, journey_start, journey_end
FROM
    journeys
WHERE
    purpose = 'Military'
ORDER BY journey_start;


-- 07.	Extract all pilots

SELECT
    c.id, CONCAT(c.first_name, ' ', c.last_name) AS full_name
FROM
    colonists AS c
        JOIN
    travel_cards AS tc ON c.id = tc.colonist_id
WHERE
    job_during_journey = 'Pilot'
ORDER BY c.id;


-- 08.	Count all colonists that are on technical journey

SELECT
    COUNT(*) AS count
FROM
    colonists AS c
        JOIN
    travel_cards AS tc ON c.id = tc.colonist_id
        JOIN
    journeys AS j ON j.id = tc.journey_id
WHERE
    j.purpose = 'Technical';


-- 09. Extract the fastest spaceship

SELECT
    s.name AS spaceship_name, sp.name AS spaceport_name
FROM
    spaceships AS s
        JOIN
    journeys AS j ON s.id = j.spaceship_id
        JOIN
    spaceports AS sp ON sp.id = j.destination_spaceport_id
ORDER BY s.light_speed_rate DESC
LIMIT 1;


-- 10.Extract spaceships with pilots younger than 30 years

SELECT
    s.name, s.manufacturer
FROM
    spaceships AS s
        JOIN
    journeys AS j ON s.id = j.spaceship_id
        JOIN
    travel_cards AS tc ON j.id = tc.journey_id
        JOIN
    colonists AS c ON c.id = tc.colonist_id
WHERE
    tc.job_during_journey = 'Pilot'
        AND TIMESTAMPDIFF(YEAR,
        c.birth_date,
        '2019-01-01') < 30
ORDER BY s.name;


-- 11. Extract all educational mission planets and spaceports

SELECT
    p.name AS planet_name, s.name AS spaceport_name
FROM
    planets AS p
        JOIN
    spaceports AS s ON p.id = s.planet_id
        JOIN
    journeys AS j ON s.id = j.destination_spaceport_id
WHERE
    j.purpose = 'Educational'
ORDER BY s.name DESC;


-- 12. Extract all planets and their journey count

SELECT
    p.name AS planet_name, COUNT(j.id) AS journeys_count
FROM
    planets AS p
        JOIN
    spaceports AS s ON p.id = s.planet_id
        JOIN
    journeys AS j ON s.id = j.destination_spaceport_id
GROUP BY (p.id)
ORDER BY journeys_count DESC , p.name;


--  13. Extract the shortest journey

SELECT
    j.id, p.name, s.name, j.purpose
FROM
    journeys AS j
        JOIN
    spaceports AS s ON s.id = j.destination_spaceport_id
        JOIN
    planets AS p ON p.id = s.planet_id
ORDER BY TIMESTAMPDIFF(YEAR,
    journey_start,
    journey_end)
LIMIT 1;


-- 14. Extract the less popular job

SELECT
    tc.job_during_journey AS job_name
FROM
    travel_cards AS tc
WHERE
    tc.journey_id = (SELECT
            j.id
        FROM
            journeys j
        ORDER BY DATEDIFF(j.journey_end, j.journey_start) DESC
        LIMIT 1)
GROUP BY tc.job_during_journey
ORDER BY COUNT(tc.job_during_journey)
LIMIT 1;
