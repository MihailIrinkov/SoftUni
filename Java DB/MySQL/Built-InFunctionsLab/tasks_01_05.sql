-- Find Book Titles_01

SELECT
    title
FROM
    books
WHERE
    SUBSTRING(title, 1, 3) = 'The'
ORDER BY id;

-- Replace Titles_02

SELECT
    REPLACE(title, 'The', '***')
FROM
    books
WHERE
    SUBSTRING(title, 1, 3) = 'The'
ORDER BY id;

-- Sum Cost of All Books_03

SELECT
    ROUND(SUM(cost), 2)
FROM
    books;

-- Days Lived_04

use book_library;

SELECT
    CONCAT(first_name, ' ', last_name) AS 'Full Name',
    TIMESTAMPDIFF(DAY, born, died) AS 'Days Lived'
FROM
    authors;

-- Harry Potter Books_05

SELECT
    title
FROM
    books
WHERE
    title LIKE '%Harry Potter%'
ORDER BY id;