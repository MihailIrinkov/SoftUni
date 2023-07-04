use soft_uni;

-- Count Employees by Town_01

DELIMITER $$

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR (50))
RETURNS int
DETERMINISTIC

begin
RETURN(SELECT
    COUNT(*)
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
    join towns as t on a.town_id = t.town_id
    WHERE t.name = town_name);
end $$
select ufn_count_employees_by_town('Sofia') as count;

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE e_count INT;
SET e_count := (SELECT COUNT(employee_id) FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON t.town_id = a.town_id
WHERE t.name = town_name);
RETURN e_count;
END



CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR (50))
RETURNS int
DETERMINISTIC

begin
declare e_count int;
set e_count := (SELECT
    COUNT(*)
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
    join towns as t on a.town_id = t.town_id
    WHERE t.name = town_name);
    return e_count;
end$$

-- Employees Promotion_02
delimiter $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR (50))
BEGIN
UPDATE employees as e
join departments as d
on e.department_id = d.department_id
set salary = salary * 1.05
WHERE d.name = department_name;
END$$

CALL usp_raise_salaries('Sales');


-- Employees Promotion by ID_03

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
begin
start transaction;

if((select count(*) from employees where employee_id = id) !=1)
then rollback;
	else

UPDATE employees as e
    set salary = salary * 1.05
    where id = e.employee_id;
    end if;
end$$


-- Triggered_04

create table deleted_employees(
employee_id int PRIMARY key AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(20),
middle_name varchar(20),
job_title varchar(50),
department_id int,
salary DOUBLE)$$

create TRIGGER tr_deleted_employees
after delete
on employees
FOR EACH ROW
begin
insert into deleted_employees(first_name,last_name,middle_name,job_title,department_id,salary)
values(old.first_name, old.last_name, old.middle_name, old.job_title, old.department_id, old.salary);
end$$

