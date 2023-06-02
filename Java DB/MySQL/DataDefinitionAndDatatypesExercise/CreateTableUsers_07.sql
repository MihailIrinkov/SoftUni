CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

insert into users(username, password)
values ('test1', 'pass'),
('test2', 'pass'),
('test3', 'pass'),
('test4', 'pass'),
('test5', 'pass');