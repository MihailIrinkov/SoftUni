-- 10.	Extract bill_010

DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19, 2)

DETERMINISTIC

BEGIN
DECLARE indexSpace int;
DECLARE bill DECIMAL(19,2);
SET indexSpace := LOCATE(' ', full_name);
RETURN (SELECT SUM(p.price)
FROM clients  as c
JOIN orders_clients as oc ON oc.client_id = c.id
JOIN orders as o ON o.id = oc.order_id
JOIN orders_products as op ON op.order_id = o.id
JOIN products as p ON p.id = op.product_id

WHERE c.first_name = substring(full_name, 1, indexSpace - 1)
AND c.last_name = substring(full_name, indexSpace + 1));


END$$

DELIMITER ;

SELECT
    c.first_name, c.last_name, SUM(p.price) AS bill
FROM
    clients AS c
        JOIN
    orders_clients AS oc ON oc.client_id = c.id
        JOIN
    orders AS o ON o.id = oc.order_id
        JOIN
    orders_products AS op ON op.order_id = o.id
        JOIN
    products AS p ON p.id = op.product_id
WHERE
    c.first_name = 'Silvio'
        AND c.last_name = 'Blyth';



SELECT
    c.first_name,
    c.last_name,
    UDF_CLIENT_BILL('Silvio Blyth') AS 'bill'
FROM
    clients AS c
WHERE
    c.first_name = 'Silvio'
        AND c.last_name = 'Blyth';



SELECT
    c.first_name,
    c.last_name,
    UDF_CLIENT_BILL(CONCAT(first_name, ' ', last_name)) AS 'bill'
FROM
    clients AS c;


-- 11.	Happy hour_011

DELIMITER $$
CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
UPDATE products as p
SET p.price = p.price * 0.8
WHERE p.price >= 10 AND type = p.type;
END$$

DELIMITER ;

CALL udp_happy_hour ('Cognac');


SELECT
    *
FROM
    products
WHERE
    type = 'Cognac';