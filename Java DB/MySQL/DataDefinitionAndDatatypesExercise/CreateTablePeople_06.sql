CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10 , 2 ),
    weight DOUBLE(10 , 2 ),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

insert into people(name, gender, birthdate)
values
('test1', 'm', DATE(NOW())),
('test2', 'f', DATE(NOW())),
('test3', 'm', DATE(NOW())),
('test4', 'f', DATE(NOW())),
('test5', 'f', DATE(NOW()));