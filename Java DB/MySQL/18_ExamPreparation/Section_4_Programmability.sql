-- 10.	Extract client cards count

DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN

	DECLARE total_number int;
	SET total_number := (SELECT count(c.first_name)
	FROM customers as c
	JOIN orders as o ON c.id = o.customer_id
	JOIN orders_products as op ON o.id = op.order_id
	WHERE c.first_name = name);
	RETURN total_number;
END$$

DELIMITER ;


SELECT
    COUNT(c.first_name)
FROM
    customers AS c
        JOIN
    orders AS o ON c.id = o.customer_id
        JOIN
    orders_products AS op ON o.id = op.order_id
WHERE
    c.first_name = 'Shirley';


-- 11.	Reduce price

DELIMITER $$

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
	UPDATE products as p
		JOIN reviews as r ON p.review_id = r.id
		JOIN categories as c ON p.category_id = c.id

SET p.price = p.price * 0.7
WHERE c.name = category_name AND r.rating < 4;
END $$

DELIMITER ;

UPDATE products as p
JOIN categories as c ON p.category_id = c.id
JOIN reviews as r ON p.review_id = r.id
SET price = price * 0.07
WHERE c.name = 'Phones and tablets' AND r.rating < 4;


call udp_reduce_price('Phones and tablets');