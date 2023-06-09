-- Mix of Peak and River Names_011

SELECT
    p.peak_name,
    r.river_name,
    LOWER(CONCAT(LEFT(p.peak_name,
                        LENGTH(p.peak_name) - 1),
                    r.river_name)) AS mix
FROM
    peaks AS p,
    rivers AS r
WHERE
    UPPER(RIGHT(p.peak_name, 1)) = UPPER(LEFT(r.river_name, 1))
ORDER BY mix;


SELECT
    p.peak_name,
    r.river_name,
    LOWER(CONCAT(p.peak_name, substring(r.river_name, 2))) AS mix
FROM
    peaks AS p,
    rivers AS r
WHERE
    UPPER(RIGHT(p.peak_name, 1)) = UPPER(LEFT(r.river_name, 1))
ORDER BY mix;


-- Games from 2011 and 2012 Year_012

use diablo;

SELECT
    name, DATE_FORMAT(start, '%Y-%m-%d') AS start
FROM
    games
WHERE
    YEAR(start) IN (2011 , 2012)
ORDER BY start , name
LIMIT 50;

-- User Email Providers_013

SELECT
    user_name,
    SUBSTRING_INDEX(email, '@', - 1) AS `email provider`
FROM
    users
ORDER BY `email provider` , user_name;

SELECT
    user_name,
    REGEXP_REPLACE(email, '.*@', '') AS `email provider`
FROM
    users
ORDER BY `email provider` , user_name;

-- Get Users with IP Address Like Pattern_014

SELECT
    user_name, ip_address
FROM
    users
WHERE
    ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

-- Show All Games with Duration and Part of the Day_015

SELECT
    name AS game,
    CASE
        WHEN HOUR(start) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(start) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN duration <= 3 THEN 'Extra Short'
        WHEN duration BETWEEN 4 AND 6 THEN 'Short'
        WHEN duration BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    games
ORDER BY name;

-- Orders Table_016

use orders;

SELECT
    product_name,
    order_date,
    DATE_ADD(order_date, INTERVAL 3 DAY) AS pay_due,
    DATE_ADD(order_date, INTERVAL 1 MONTH)
FROM
    orders;