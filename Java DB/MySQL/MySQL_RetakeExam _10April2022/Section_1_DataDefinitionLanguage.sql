CREATE DATABASE softuni_imdb;

USE softuni_imdb;

-- 01.	Table Design

CREATE TABLE countries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    continent VARCHAR(30) NOT NULL,
    currency VARCHAR(5) NOT NULL
);


CREATE TABLE genres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE actors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    height INT,
    awards INT,
    country_id INT NOT NULL,
    CONSTRAINT fk_actors_countries FOREIGN KEY (country_id)
        REFERENCES countries (id)
);

CREATE TABLE movies_additional_info (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rating DECIMAL(10 , 2 ) NOT NULL,
    runtime INT NOT NULL,
    picture_url VARCHAR(80) NOT NULL,
    budget DECIMAL(10,2),
    release_date DATE NOT NULL,
    has_subtitles TINYINT(1),
    description TEXT
);

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(70) NOT NULL UNIQUE,
    country_id INT NOT NULL,
    movie_info_id INT NOT NULL UNIQUE,
    CONSTRAINT fk_movies_countries FOREIGN KEY (country_id)
        REFERENCES countries (id),
    CONSTRAINT fk_movies_movies_additional_info FOREIGN KEY (movie_info_id)
        REFERENCES movies_additional_info (id)
);

CREATE TABLE movies_actors (
    movie_id INT,
    actor_id INT,
    CONSTRAINT fk_movies_actors_movies FOREIGN KEY (movie_id)
        REFERENCES movies (id),
    CONSTRAINT fk_movies_actors_actors FOREIGN KEY (actor_id)
        REFERENCES actors (id)
);

CREATE TABLE genres_movies (
    genre_id INT,
    movie_id INT,
    CONSTRAINT fk_genres_movies_genres FOREIGN KEY (genre_id)
        REFERENCES genres (id),
    CONSTRAINT fk_genres_movies_movies FOREIGN KEY (movie_id)
        REFERENCES movies (id)
);