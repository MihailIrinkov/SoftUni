-- Min Average Salary_011

SELECT
    AVG(salary) AS min_avarage_salary
FROM
    employees
GROUP BY department_id
ORDER BY min_avarage_salary
LIMIT 1;


-- Highest Peaks in Bulgaria_012

SELECT
    c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    countries AS c
        JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        JOIN
    mountains AS m ON m.id = mc.mountain_id
        JOIN
    peaks AS p ON p.mountain_id = m.id
WHERE
    c.country_code LIKE 'BG'
        AND p.elevation > 2835
ORDER BY p.elevation DESC;


-- Count Mountain Ranges_013

SELECT
    mc.country_code, COUNT(m.mountain_range) AS mountain_range
FROM
    mountains_countries AS mc
        JOIN
    mountains AS m ON mc.mountain_id = m.id
GROUP BY mc.country_code
HAVING mc.country_code IN ('BG' , 'US', 'RU')
ORDER BY COUNT(mountain_range) DESC;


-- Countries with Rivers_014


SELECT
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
WHERE
    c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;


-- *Continents and Currencies_015

SELECT
    c.continent_code,
    c.currency_code,
    COUNT(*) AS currency_usage
FROM
    countries AS c
GROUP BY c.continent_code , c.currency_code
HAVING currency_usage > 1
    AND currency_usage = (SELECT
        COUNT(*) AS count1
    FROM
        countries AS c2
    WHERE
        c2.continent_code = c.continent_code
    GROUP BY c2.currency_code
    ORDER BY count1 DESC
    LIMIT 1)
ORDER BY c.continent_code , c.currency_code;


