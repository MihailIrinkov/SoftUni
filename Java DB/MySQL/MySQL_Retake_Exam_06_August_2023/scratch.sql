CREATE DATABASE real_estate_db;
USE real_estate_db;

CREATE TABLE cities (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE property_types (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `type` VARCHAR(40) NOT NULL UNIQUE,
    `description` TEXT
);

CREATE TABLE properties (
    id INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(80) NOT NULL UNIQUE,
    price DECIMAL(19,2) NOT NULL,
    area DECIMAL(19,2),
    property_type_id INT,
    CONSTRAINT fk_properties_property_types FOREIGN KEY (property_type_id)
        REFERENCES property_types(id),
    city_id INT,
    CONSTRAINT fk_properties_cities FOREIGN KEY (city_id)
        REFERENCES cities(id)
);

CREATE TABLE agents (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,
    CONSTRAINT fk_agents_cities FOREIGN KEY (city_id)
        REFERENCES cities(id)
);

CREATE TABLE buyers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,
    CONSTRAINT fk_buyers_cities FOREIGN KEY (city_id)
        REFERENCES cities(id)
);

CREATE TABLE property_offers (
    property_id INT NOT NULL,
    agent_id INT NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    offer_datetime DATETIME,

    CONSTRAINT fk_property_offers_properties FOREIGN KEY (property_id)
        REFERENCES properties(id),
    CONSTRAINT fk_property_offers_agents FOREIGN KEY (agent_id)
        REFERENCES agents(id)
);

CREATE TABLE property_transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT NOT NULL,
    CONSTRAINT fk_property_transactions_properties FOREIGN KEY (property_id)
        REFERENCES properties(id),
    buyer_id INT NOT NULL,
    CONSTRAINT fk_property_transactions_buyers FOREIGN KEY (buyer_id)
        REFERENCES buyers(id),
    transaction_date DATE,
    bank_name VARCHAR(30),
    iban VARCHAR(40) UNICODE,
    is_successful TINYINT(1)
);



 -- 02.	Insert


 INSERT INTO property_transactions(property_id, buyer_id,
 transaction_date, bank_name, iban, is_successful )
 SELECT po.agent_id + day(po.offer_datetime),
 po.agent_id + month(po.offer_datetime),
 date(po.offer_datetime),
 concat('Bank', ' ', po.agent_id),
 concat('BG', po.price, po.agent_id),
 1
 FROM property_offers as po
 WHERE po.agent_id <= 2;


 -- 03.	Update
 SET SQL_SAFE_UPDATES = 0;
 UPDATE properties
SET
    price = price - 50000
WHERE
    price >= 800000;


 -- 04.	Delete

 DELETE pt FROM property_transactions AS pt
WHERE
    is_successful = 0;


--   05.	Agents

SELECT
    id, first_name, last_name, phone, email, city_id
FROM
    agents
ORDER BY city_id DESC , phone DESC;


--  06.	Offers from 2021

SELECT
    property_id, agent_id, price, offer_datetime
FROM
    property_offers
WHERE
    YEAR(offer_datetime) = 2021
ORDER BY price
LIMIT 10;


-- 07.	Properties without offers

SELECT
    SUBSTRING(p.address, 1, 6) AS agent_name,
    CHAR_LENGTH(p.address) * 5430 AS price
FROM
    properties AS p
        LEFT JOIN
    property_offers AS po ON p.id = po.property_id
WHERE
    po.offer_datetime IS NULL
ORDER BY agent_name DESC , price DESC;


-- 08.	Best Banks

SELECT
    pt.bank_name, COUNT(pt.iban) AS `count`
FROM
    property_transactions AS pt
GROUP BY pt.bank_name
HAVING `count` >= 9
ORDER BY `count` DESC , pt.bank_name;


-- 09.	Size of the area

SELECT
    address,
    area,
    CASE
        WHEN area <= 100 THEN 'small'
        WHEN area <= 200 THEN 'medium'
        WHEN area <= 500 THEN 'large'
        WHEN area > 500 THEN 'extra large'
    END AS size
FROM
    properties
ORDER BY area , address DESC;


-- 10.	Offers count in a city

DELIMITER $$
CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))

RETURNS INT
DETERMINISTIC
BEGIN
DECLARE c_caount INT;
set c_caount := (SELECT count(po.property_id)
FROM properties as p
JOIN cities as c ON p.city_id = c.id
JOIN property_offers as po ON p.id = po.property_id
GROUP BY c.name
HAVING c.name = cityName);
RETURN c_caount;
END $$

DELIMITER ;

SELECT
    COUNT(po.property_id)
FROM
    properties AS p
        JOIN
    cities AS c ON p.city_id = c.id
        JOIN
    property_offers AS po ON p.id = po.property_id
GROUP BY c.name
HAVING c.name = 'Vienna';


-- 11.	Special Offer

DELIMITER $$

CREATE PROCEDURE udp_special_offer(first_name VARCHAR(50))
BEGIN

UPDATE property_offers as po
JOIN agents as a ON po.agent_id = a.id
SET po.price = po.price * 0.90
WHERE a.first_name = `first_name`;

END $$

DELIMITER ;



UPDATE property_offers as po
JOIN agents as a ON po.agent_id = a.id
SET po.price = po.price * 0.90
WHERE a.first_name = 'Hans';

CALL udp_special_offer('Hans');


SET SQL_SAFE_UPDATES = 0;


SELECT *
FROM properties as p
JOIN property_offers as po ON p.id = po.property_id
JOIN agents as a ON po.agent_id = a.id
WHERE a.first_name = 'Hans';
