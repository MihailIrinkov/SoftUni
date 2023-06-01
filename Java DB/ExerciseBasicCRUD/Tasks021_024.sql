-- All Mountain Peaks_021

SELECT
    peak_name
FROM
    peaks
ORDER BY peak_name;

-- Biggest Countries by Population_022

SELECT
    country_name, population
FROM
    countries
WHERE
    continent_code = 'EU'
ORDER BY population DESC , country_name
LIMIT 30;

-- Countries and Currency (Euro / Not Euro)_023

SELECT
    country_name,
    country_code,
    IF(currency_code = 'EUR',
        'Euro',
        'Not Euro') AS currency
FROM
    countries
ORDER BY country_name;

-- All Diablo Characters_024

use Diablo;

SELECT
    name
FROM
    characters
ORDER BY name;

