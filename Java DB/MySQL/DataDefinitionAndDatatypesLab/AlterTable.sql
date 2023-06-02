alter table minions ADD column town_id int;

alter table minions
add constraint fk_minions_towns
foreign key minions(town_id)
references towns(id);

-- Alter Tables_03

alter table employees
add middle_name varchar(30);

