-- One-To-One Relationship_01

CREATE TABLE people (
    person_id INT UNIQUE NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    salary DECIMAL(10 , 2 ) DEFAULT 0,
    passport_id INT UNIQUE
);

CREATE TABLE passports (
    passport_id INT PRIMARY KEY AUTO_INCREMENT,
    passport_number VARCHAR(8) UNIQUE
);

ALTER table people
add CONSTRAINT pk_people
PRIMARY KEY (person_id),
ADD CONSTRAINT fk_people_passports
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);

insert INTO passports(passport_id, passport_number)
VALUES(101, 'N34FG21B'), (102, 'K65LO4R7'), (103, 'ZE657QP2');

INSERT INTO people(first_name, salary, passport_id)
values ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);


-- One-To-Many Relationship_02

CREATE TABLE manufacturers (
    manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    established_on DATE NOT NULL
);

CREATE TABLE models (
    model_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    manufacturer_id INT
);

ALTER TABLE models
ADD CONSTRAINT fk_models_manufacturers
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id);

INSERT INTO manufacturers(name, established_on)
VALUES
('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

ALTER TABLE models AUTO_INCREMENT = 101;

INSERT INTO models(name, manufacturer_id)
VALUES ('X1', 1),
('i6', 1),
('Model S', 2),
('Model X', 2),
('Model 3', 2),
('Nova', 3);


-- Many-To-Many Relationship_03

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE exams (
    exam_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
)  AUTO_INCREMENT=101;

CREATE TABLE students_exams (
    student_id INT,
    exam_id INT,
    CONSTRAINT pk_students_exams PRIMARY KEY (student_id , exam_id),
    CONSTRAINT fk_students_exams_students FOREIGN KEY (student_id)
        REFERENCES students (student_id),
    CONSTRAINT fk_students_exams_exams FOREIGN KEY (exam_id)
        REFERENCES exams (exam_id)
);

INSERT INTO students(name)
VALUES('Mila'), ('Toni'), ('Ron');

insert INTO exams(name)
VALUES ('Spring MVC'), ('Neo4j'), ('Oracle 11g');


-- Self-Referencing_04


use test_me;

DROP TABLE teachers;

CREATE TABLE teachers (
    teacher_id INT UNSIGNED UNIQUE AUTO_INCREMENT,
    name VARCHAR(50),
    manager_id INT UNSIGNED DEFAULT NULL
)  AUTO_INCREMENT=101;

INSERT INTO teachers(name, manager_id)
VALUES

('John', NULL),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark',101),
('Greta',101);


ALTER TABLE teachers
ADD CONSTRAINT pk_teachers
PRIMARY KEY(teacher_id),
ADD CONSTRAINT fk_techers_managers
FOREIGN KEY (manager_id)
REFERENCES teachers(teacher_id);


-- Online Store Database_05

CREATE DATABASE onlineStoreDatabase;
use onlineStoreDatabase;

CREATE TABLE cities (
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE item_types (
    item_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    item_type_id INT,
    CONSTRAINT fk_items_item_types FOREIGN KEY (item_type_id)
        REFERENCES item_types (item_type_id)
);


CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    birthday DATE,
    city_id INT,
    CONSTRAINT fk_customers_cities FOREIGN KEY (city_id)
        REFERENCES cities (city_id)
);


CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    CONSTRAINT fk_orders_customers FOREIGN KEY (order_id)
        REFERENCES customers (customer_id)
);


CREATE TABLE order_items (
    order_id INT,
    item_id INT,
    CONSTRAINT pk_order_item PRIMARY KEY (order_id , item_id),
    CONSTRAINT fk_order_id_orders FOREIGN KEY (order_id)
        REFERENCES orders (order_id),
    CONSTRAINT fk_item_id_items FOREIGN KEY (item_id)
        REFERENCES items (item_id)
);