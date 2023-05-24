create table employees(
id INT primary key AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL
);
create table categories(
id INT primary key AUTO_INCREMENT,
name VARCHAR(30) NOT NULL
);

create table products(
id INT primary key AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
category_id INT NOT NULL
);