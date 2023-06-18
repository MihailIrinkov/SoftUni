CREATE DATABASE mountains;
use mountains;

-- Mountains and Peaks_01
CREATE TABLE mountains (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50) NOT NULL
);


CREATE TABLE peaks (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    mountain_id INT,
    CONSTRAINT fk_peaks_mauntains FOREIGN KEY (mountain_id)
        REFERENCES mountains (id)
);

-- Trip Organization_02

use camp;

SELECT
    driver_ID,
    vehicle_type,
    CONCAT(first_name, ' ', last_name) AS 'driver_name'
FROM
    vehicles
        JOIN
    campers ON driver_id = campers.id;

-- SoftUni Hiking_03

SELECT
    starting_point AS route_starting_point,
    end_point AS route_end_point,
    leader_id,
    CONCAT(first_name, ' ', last_name) AS leader_name
FROM
    routes
        JOIN
    campers ON campers.id = routes.leader_id;

-- Delete Mountains_04

drop TABLE mountains, peaks;

CREATE TABLE mountains (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE peaks (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50),
    mountain_id INT,
    CONSTRAINT fk_mountain_id FOREIGN KEY (mountain_id)
        REFERENCES mountains (id)
        ON DELETE CASCADE
);

-- Project Management DB*_05

CREATE TABLE clients (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_name VARCHAR(100)
);

CREATE TABLE projects (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_id INT,
    project_lead_id INT,
    CONSTRAINT fk_projects_client_id_clients_id FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT,
    CONSTRAINT fk_proct_id_projects_id FOREIGN KEY (project_id)
        REFERENCES projects (id)
);

alter table projects
add CONSTRAINT
fk_project_lead_id_employees_id
FOREIGN KEY (project_lead_id)
REFERENCES employees(id);