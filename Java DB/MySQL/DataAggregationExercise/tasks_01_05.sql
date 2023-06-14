--  Records’ Count_01

SELECT
    COUNT(id) AS 'Count'
FROM
    wizzard_deposits;

--  Records’ Count_01

SELECT
    COUNT(*) AS 'Count'
FROM
    wizzard_deposits;

-- Longest Magic Wand_02

SELECT
    MAX(magic_wand_size) AS 'longest_magic_wand'
FROM
    wizzard_deposits;

    -- Longest Magic Wand Per Deposit Groups_03

SELECT
    deposit_group, MAX(magic_wand_size) AS 'longest_magic_wand'
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand` , deposit_group;

-- Smallest Deposit Group Per Magic Wand Size_04

SELECT
    deposit_group
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size) ASC
LIMIT 1;

SELECT
    deposit_group
FROM
    wizzard_deposits
GROUP BY deposit_group
HAVING MIN(magic_wand_size)
LIMIT 1;

-- Deposits Sum_05

SELECT
    deposit_group, SUM(deposit_amount) AS 'total_sum'
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `total_sum`;


