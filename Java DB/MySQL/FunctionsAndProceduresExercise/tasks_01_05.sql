set sql_safe_updates = 0;

-- Employees with Salary Above 35000_01
delimiter $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
begin
SELECT first_name, last_name
FROM employees
WHERE salary > 35000
ORDER BY first_name, last_name, employee_id;
end$$
delimiter ;
CALL usp_get_employees_salary_above_35000;

-- Employees with Salary Above Number_02

delimiter $$
CREATE PROCEDURE usp_get_employees_salary_above(given_number DOUBLE(19,4))
BEGIN
SELECT first_name, last_name
FROM employees
WHERE salary >= given_number
ORDER BY first_name, last_name, employee_id;
end$$
delimiter ;

call usp_get_employees_salary_above(45000);


-- Town Names Starting With_03

delimiter $$
CREATE PROCEDURE usp_get_towns_starting_with(name_starts_with VARCHAR(50))
BEGIN
SELECT name as town_name
FROM towns
WHERE name like concat(name_starts_with, '%')
ORDER BY name;
END$$

delimiter ;
call usp_get_towns_starting_with('b');


-- Employees from Town_04

delimiter $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
SELECT e.first_name, e.last_name
FROM employees as e
JOIN addresses as a on e.address_id = a.address_id
JOIN towns as t on a.town_id = t.town_id
WHERE t.name = town_name
ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

delimiter ;
call usp_get_employees_from_town('Sofia');


-- Salary Level Function_05

CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(7)
DETERMINISTIC
RETURN(
case when salary < 30000
then 'Low'
when salary <= 50000
then 'Average'
else 'High'
end
);

select ufn_get_salary_level(50000);


