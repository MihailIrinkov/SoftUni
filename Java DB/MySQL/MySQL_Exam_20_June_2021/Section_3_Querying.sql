
-- 5.	Cars

SELECT
    make, model, `condition`
FROM
    cars
ORDER BY id;


-- 6.	Drivers and Cars

SELECT
    d.first_name, d.last_name, c.make, c.model, c.mileage
FROM
    drivers AS d
        JOIN
    cars_drivers AS cd ON d.id = cd.driver_id
        JOIN
    cars AS c ON cd.car_id = c.id
WHERE
    c.mileage IS NOT NULL
ORDER BY c.mileage DESC , d.first_name;


-- 7.	Number of courses for each car


SELECT
    c.id AS car_id,
    c.make,
    c.mileage,
    IF(AVG(co.bill) IS NOT NULL,
        COUNT(c.id),
        0) AS count_of_courses,
    ROUND(AVG(co.bill), 2) AS avg_bill
FROM
    cars AS c
        LEFT JOIN
    courses AS co ON c.id = co.car_id
GROUP BY c.id
HAVING count_of_courses <> 2
ORDER BY count_of_courses DESC , c.id;


-- 8.	Regular clients


SELECT
    c.full_name,
    COUNT(co.id) AS count_of_cars,
    SUM(co.bill) AS total_sum
FROM
    clients AS c
        JOIN
    courses AS co ON c.id = co.client_id
GROUP BY c.id
HAVING c.full_name LIKE '_a%'
    AND count_of_cars > 1
ORDER BY full_name;


-- 9.	Full information of courses


SELECT
    a.name,
    CASE
        WHEN HOUR(co.start) BETWEEN 6 AND 20 THEN 'Day'
        WHEN HOUR(co.start) BETWEEN 21 AND 24 THEN 'Night'
        WHEN HOUR(co.start) BETWEEN 1 AND 5 THEN 'Night'
        WHEN HOUR(co.start) BETWEEN 0 AND 1 THEN 'Night'
    END AS day_time,
    co.bill,
    c.full_name,
    ca.make,
    ca.model,
    cat.name AS category_name
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
ORDER BY co.id;