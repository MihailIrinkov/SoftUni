alter table products
add constraint category_id
foreign key(category_id) references categories(id);

-- Modifying Columns_05

alter table employees
change column middle_name
middle_name varchar(100);