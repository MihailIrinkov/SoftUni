create table countries(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(40) not null UNIQUE
);

create table cities(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(40) not null UNIQUE,
country_id int not null,
population int,
CONSTRAINT fk_country_id_countries_id
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

CREATE TABLE universities(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(60) not null UNIQUE,
address varchar(80) not null UNIQUE,
tuition_fee DECIMAL(19 , 2 ) not null,
number_of_staff int,
city_id int,
CONSTRAINT fk_city_id_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

CREATE TABLE students(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(40) not null,
last_name varchar(40) not null,
age int,
phone varchar(20) not null UNIQUE,
email varchar(255) not null UNIQUE,
is_graduated BOOLEAN not null,
city_id int,
CONSTRAINT fk_students_id_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

CREATE TABLE courses(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(40) not null UNIQUE,
duration_hours DECIMAL(19 , 2 ),
start_date DATE,
teacher_name varchar(60) not null UNIQUE,
description TEXT,
university_id int,
CONSTRAINT fk_courses_id_universities
FOREIGN KEY (university_id)
REFERENCES universities(id)
);

CREATE TABLE students_courses(
grade DECIMAL(19 , 2 ) not null,
student_id int not null,
course_id int not null,




CONSTRAINT fk_student_id_students
FOREIGN KEY (student_id)
REFERENCES students(id),

CONSTRAINT fk_course_id_courses
FOREIGN KEY (course_id)
REFERENCES courses(id)
);

UPDATE courses

set
duration_hours = CHAR_LENGTH(courses.name) / 10,
start_date  = start_date + INTERVAL 5 DAY,
teacher_name = REVERSE(courses.teacher_name),
description  = concat('Course', courses.teacher_name, REVERSE(courses.description ),
university_id = DAY(start_date))
where id <= 5;



UPDATE universities
set tuition_fee = tuition_fee + 300
WHERE id BETWEEN 5 and 12;

SET SQL_SAFE_UPDATES = 0;

DELETE from universities

WHERE number_of_staff is null;


select id, name, population, country_id from cities
ORDER BY population desc;


select first_name, last_name, age, phone, email from students
where age <= 21
ORDER BY first_name desc, email asc, id asc limit 10;

