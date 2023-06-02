create database car_rental;
use car_rental;

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(30) not null,
    daily_rate DOUBLE(10 , 2 ),
    weekly_rate DOUBLE(10 , 2 ),
    monthly_rate DOUBLE(10 , 2 ),
    weekend_rate DOUBLE(10 , 2 )
);

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(20) not null,
    make VARCHAR(20),
    model VARCHAR(20),
    car_year DATE,
    category_id INT,
    doors INT,
    picture BLOB,
    car_condition DOUBLE(10 , 2 ),
    available VARCHAR(10)
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) not null,
    last_name VARCHAR(30),
    title VARCHAR(30),
    notes TEXT
);

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT not null,
    full_name VARCHAR(30),
    address VARCHAR(200),
    city VARCHAR(100),
    zip_code VARCHAR(10),
    notes TEXT
);

CREATE TABLE rental_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition DOUBLE(10 , 2 ),
    tank_level DOUBLE(10 , 2 ),
    kilometrage_start DOUBLE(100 , 2 ),
    kilometrage_end DOUBLE(100 , 2 ),
    total_kilometrage DOUBLE(100 , 2 ),
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DOUBLE(10 , 2 ),
    tax_rate DOUBLE(10 , 2 ),
    order_status VARCHAR(10) not null,
    notes TEXT
);

insert into cars (plate_number)
values('A1012HP'),
('A1013HP'),
('A1014HP');

insert into categories(category)
values ('car'),
('car'),
('car');

insert into customers(driver_licence_number)
values (123),
(234),
(345);

insert into employees(first_name)
values('Pesho'),
('Pesho'),
('Pesho');

insert into rental_orders(order_status)
values ('aktiv'),
('aktiv'),
('aktiv');