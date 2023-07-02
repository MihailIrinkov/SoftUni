-- Countries Without Any Mountains_016

SELECT
    COUNT(*) AS country_count
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
WHERE
    mc.mountain_id IS NULL;

-- Highest Peak and Longest River by Country_017

SELECT
    c.country_name,
    MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc ON c.country_code = mc.country_code
        LEFT JOIN
    peaks AS p ON mc.mountain_id = p.mountain_id
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
GROUP BY country_name
ORDER BY p.elevation DESC , c.country_name
LIMIT 5;