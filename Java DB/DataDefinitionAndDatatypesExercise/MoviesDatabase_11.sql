--create database Movies;
--use movies;
--
--create table directors (
--id int primary key auto_increment,
--director_name varchar(30) not null,
--notes text);
--
--insert into directors(director_name)
--values
--('test1'),
--('test2'),
--('test3'),
--('test4'),
--('test5');
--
--create table genres (
--id int primary key auto_increment,
--genre_name varchar(30) not null,
--notes text);
--
--insert into genres(genre_name)
--values
--('test1'),
--('test2'),
--('test3'),
--('test4'),
--('test5');
--
--create table categories (
--id int primary key auto_increment,
--category_name varchar(90) not null,
--notes text);
--
--insert into categories(category_name)
--values
--('test1'),
--('test2'),
--('test3'),
--('test4'),
--('test5');
--
--create table movies (
--id int primary key auto_increment,
--title varchar(100) not null,
--director_id int,
--copyright_year year,
--length double(10,2),
--genre_id int,
--category_id int,
--rating double(3,2),
--notes text,
--
--foreign key fk_movies_directors (director_id)
--references directors(id),
--
--foreign key fk_movies_genres(genre_id)
--references genres(id),
--
--foreign key fk_movies_categories(category_id)
--references categories(id)
--);
--
--insert into movies(title)
--values
--('test1'),
--('test2'),
--('test3'),
--('test4'),
--('test5');

create table directors (
id int primary key auto_increment,
director_name varchar(30) not null,
notes text);

insert into directors(director_name)
values
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

create table genres (
id int primary key auto_increment,
genre_name varchar(30) not null,
notes text);

insert into genres(genre_name)
values
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

create table categories (
id int primary key auto_increment,
category_name varchar(90) not null,
notes text);

insert into categories(category_name)
values
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

create table movies (
id int primary key auto_increment,
title varchar(100) not null,
director_id int,
copyright_year year,
length double(10,2),
genre_id int,
category_id int,
rating double(3,2),
notes text);

insert into movies(title)
values
('test1'),
('test2'),
('test3'),
('test4'),
('test5');