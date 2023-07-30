-- 02.	Insert

INSERT INTO reviews(content, picture_url, published_at, rating)
SELECT LEFT(p.description, 15),
reverse(p.name),
DATE('2010/10/10'),
p.price / 8
FROM products as p
WHERE id >= 5;


-- 03.	Update

UPDATE products
SET
    quantity_in_stock = quantity_in_stock - 5
WHERE
    quantity_in_stock BETWEEN 60 AND 70;

-- 04.	Delete
DELETE c FROM customers AS c
        LEFT JOIN
    orders AS o ON o.customer_id = c.id
WHERE
    o.id IS NULL;



