-- 05.	Clients_05

SELECT
    id, first_name, last_name, birthdate, card, review
FROM
    clients
ORDER BY birthdate DESC , id DESC;

-- 06.	Birthdate_06

SELECT
    first_name, last_name, birthdate, review
FROM
    clients
WHERE
    card IS NULL
        AND YEAR(birthdate) BETWEEN '1978' AND '1993'
ORDER BY last_name DESC , id
LIMIT 5;

-- 07.	Accounts_07

SELECT
    CONCAT(last_name,
            first_name,
            LENGTH(first_name),
            'Restaurant') AS username,
    REVERSE(SUBSTRING(email, 2, 12)) AS password
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY password DESC;

-- 07.	Accounts_07

SELECT
    CONCAT(last_name,
            first_name,
            LENGTH(first_name),
            'Restaurant') AS username,
    REVERSE(SUBSTRING(email, 2, 12)) AS password
FROM
    waiters
WHERE
    salary IS NOT NULL
ORDER BY password DESC;


-- 08.	Top from menu_08

SELECT
    p.id, p.name, COUNT(op.product_id) AS `count`
FROM
    products AS p
        JOIN
    orders_products AS op ON op.product_id = p.id
GROUP BY p.id
HAVING `count` >= 5
ORDER BY `count` DESC , p.name ASC;


-- 09.	Availability_09

SELECT
    t.id AS table_id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    IF(t.capacity > COUNT(oc.client_id),
        'Free seats',
        IF(t.capacity < COUNT(oc.client_id),
            'Extra seats',
            'Full')) AS availability
FROM
    tables AS t
        JOIN
    orders AS o ON o.table_id = t.id
        JOIN
    orders_clients AS oc ON o.id = oc.order_id
WHERE
    floor = 1
GROUP BY t.id
ORDER BY table_id DESC;



