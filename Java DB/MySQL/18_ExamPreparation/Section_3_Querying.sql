-- 05.	Categories

SELECT
    id, name
FROM
    categories
ORDER BY name DESC;

-- 06.	Quantity

SELECT
    id, brand_id, name, quantity_in_stock
FROM
    products
WHERE
    price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock , id;


-- 07.	Review

SELECT
    id, content, rating, picture_url, published_at
FROM
    reviews
WHERE
    content LIKE 'My%'
        AND CHARACTER_LENGTH(content) > 61
        ORDER BY rating DESC;


-- 08.	First customers

SELECT
    CONCAT_WS(' ', c.first_name, c.last_name) AS full_name,
    c.address,
    o.order_datetime AS order_date
FROM
    customers AS c
        JOIN
    orders AS o ON c.id = o.customer_id
WHERE
    YEAR(order_datetime) <= 2018
ORDER BY full_name DESC;


-- 09.	Best categories

SELECT
    COUNT(c.name) AS item_count,
    c.name,
    SUM(quantity_in_stock) AS total_quantity
FROM
    categories AS c
        JOIN
    products AS p ON c.id = p.category_id
GROUP BY c.name
ORDER BY item_count DESC , total_quantity
LIMIT 5;


