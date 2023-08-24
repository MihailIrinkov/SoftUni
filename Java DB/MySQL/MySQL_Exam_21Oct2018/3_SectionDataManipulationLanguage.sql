-- 01.	Data Insertion

INSERT INTO travel_cards(card_number, job_during_journey, colonist_id, journey_id)
SELECT
(
CASE
WHEN c.birth_date > '1980-01-01' THEN concat(year(c.birth_date), day(c.birth_date), substring(c.ucn, 1, 4))
ELSE concat(year(c.birth_date), month(c.birth_date), substring(c.ucn, 7))
END
) as card_number,
(
CASE
WHEN c.id % 2 = 0 THEN 'Pilot'
WHEN c.id % 3 = 0 THEN 'Cook'
ELSE 'Engineer'
END
) as job_during_journey,
c.id,
(
substring(c.ucn, 1, 1)
) as journey_id
FROM colonists as c
WHERE id BETWEEN 96 AND 100;


-- 02.	Data Update

SET SQL_SAFE_UPDATES = 0;

UPDATE journeys
SET
    purpose = (CASE
        WHEN id % 2 = 0 THEN 'Medical'
        WHEN id % 3 = 0 THEN 'Technical'
        WHEN id % 5 = 0 THEN 'Educational'
        WHEN id % 7 = 0 THEN 'Military'
        ELSE purpose
    END);

-- 03.	Data Deletion

DELETE c FROM colonists AS c
        LEFT JOIN
    travel_cards AS tc ON c.id = tc.colonist_id
WHERE
    journey_id IS NULL;