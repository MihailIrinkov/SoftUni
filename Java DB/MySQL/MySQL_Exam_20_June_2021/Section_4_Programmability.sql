-- 10.	Find all courses by client’s phone number

DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC

BEGIN
DECLARE count_courses INT;
SET count_courses := (
SELECT COUNT(c.id)
FROM clients as c
JOIN courses as co ON c.id = co.client_id
WHERE phone_number = phone_num
);
RETURN count_courses;

END $$

DELIMITER ;


SELECT COUNT(c.id)
FROM clients as c
JOIN courses as co ON c.id = co.client_id
WHERE phone_number = '(803) 6386812';

SELECT udf_courses_by_client ('(831) 1391236') as `count`;


-- 11.	Full info for address

DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))

BEGIN
SELECT
    a.name,
    c.full_name,
    CASE
        WHEN co.bill <= 20 THEN 'Low'
        WHEN co.bill <= 30 THEN 'Medium'
        WHEN co.bill > 30 THEN 'High'
    END AS level_of_bill,
    ca.make,
    ca.condition,
    cat.name AS cat_name
FROM
    addresses AS a
        JOIN
    courses AS co ON a.id = co.from_address_id
        JOIN
    clients AS c ON co.client_id = c.id
        JOIN
    cars AS ca ON co.car_id = ca.id
        JOIN
    categories AS cat ON ca.category_id = cat.id
WHERE
    a.name = address_name
ORDER BY ca.make , c.full_name;
END $$

DELIMITER ;

SELECT
    a.name,
    c.full_name,
    CASE
        WHEN co.bill <= 20 THEN 'Low'
        WHEN co.bill <= 30 THEN 'Medium'
        WHEN co.bill > 30 THEN 'High'
    END AS level_of_bill,
    ca.make,
    ca.condition,
    cat.name AS cat_name
FROM
    addresses AS a
        JOIN
    courses AS co ON a.id = co.from_address_id
        JOIN
    clients AS c ON co.client_id = c.id
        JOIN
    cars AS ca ON co.car_id = ca.id
        JOIN
    categories AS cat ON ca.category_id = cat.id
WHERE
    a.name = '700 Monterey Avenue'
ORDER BY ca.make , c.full_name;

CALL udp_courses_by_address('700 Monterey Avenue');

CALL udp_courses_by_address('66 Thompson Drive');