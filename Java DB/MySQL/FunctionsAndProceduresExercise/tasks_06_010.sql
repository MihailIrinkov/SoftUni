-- Employees by Salary Level_06

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
SELECT e.first_name, e.last_name
FROM employees as e
WHERE e.salary < 30000 and salary_level = 'low'
or e.salary >= 30000 and e.salary <= 50000 and salary_level = 'average'
or e.salary > 50000 and salary_level = 'high'
ORDER BY first_name desc, last_name desc;
END $$

DELIMITER ;

call usp_get_employees_by_salary_level('average');


-- Define Function_07

CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
RETURN  word REGEXP (concat ('^[', set_of_letters, ']+$'));

SELECT UFN_IS_WORD_COMPRISED('oistmiahf', 'Sofia');

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised2(set_of_letters varchar(50), word varchar(50))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE result int;

set result := (
word REGEXP (concat ('^[', set_of_letters, ']+$'))
);
return result;
END$$

DELIMITER ;

SELECT UFN_IS_WORD_COMPRISED2('oistmiahf', 'Sofia');


use soft_uni;

-- Find Full Name_08
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT
concat_ws(' ', first_name, last_name) as full_name
FROM account_holders
ORDER BY full_name, id;
END&&

DELIMITER ;

call usp_get_holders_full_name;



-- People with Balance Higher Than_09
DELIMITER $$

CREATE procedure usp_get_holders_with_balance_higher_than(more_money decimal(19,4))
BEGIN
SELECT ah.first_name, ah.last_name
from account_holders as ah
JOIN accounts as a on ah.id = a.account_holder_id
GROUP BY ah.id
having SUM(a.balance) > more_money
ORDER BY a.account_holder_id;
END $$
DELIMITER ;

call usp_get_holders_with_balance_higher_than(7000);


-- Future Value Function_010

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(Initial_sum decimal(19,4), yearly_interest_rate double, number_of_years int)
RETURNS decimal(19,4)
DETERMINISTIC
BEGIN
RETURN (
Initial_sum * pow((1 + yearly_interest_rate), number_of_years)
);
END $$

DELIMITER ;

SELECT UFN_CALCULATE_FUTURE_VALUE(1000, 0.5, 5);