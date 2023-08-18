-- 2.	Insert


INSERT INTO clients(full_name, phone_number)
SELECT concat(d.first_name, ' ', d.last_name), concat('(088) 9999', d.id * 2)
FROM drivers as d
WHERE d.id between 10 and 20;


 SET SQL_SAFE_UPDATES = 0;
 -- 3.	Update

UPDATE cars
SET
    `condition` = 'C'
WHERE
    mileage >= 800000
        OR mileage IS NULL AND year <= 2010
        AND make <> 'Mercedes-Benz';

SELECT COUNT(*) FROM cars WHERE `condition` = 'C';


-- 4.	Delete


DELETE c FROM clients AS c
        LEFT JOIN
    courses AS co ON co.client_id = c.id
WHERE
    co.id IS NULL
    AND CHAR_LENGTH(c.full_name) > 3;


SELECT *
FROM clients as c
LEFT JOIN courses as co ON co.client_id = c.id;