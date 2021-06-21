-- Task 1.
CREATE DATABASE `stc`;

USE `stc`;

CREATE TABLE `drivers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `age` INT NOT NULL,
    `rating` FLOAT DEFAULT 5.5
);

CREATE TABLE `cars_drivers` (
	`car_id` INT NOT NULL,
	`driver_id` INT NOT NULL,
    CONSTRAINT pk_cars_drivers
    PRIMARY KEY (`car_id`, `driver_id`),
    CONSTRAINT fk_cars_drivers_drivers
    FOREIGN KEY (`driver_id`)
    REFERENCES `drivers` (`id`)
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `make` VARCHAR(20) NOT NULL,
    `model` VARCHAR(20),
    `year` INT NOT NULL DEFAULT 0,
    `mileage` INT DEFAULT 0,
    `condition` CHAR(1) NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT fk_cars_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`)
);

ALTER TABLE `cars_drivers` 
ADD CONSTRAINT fk_cars_drivers_cars
FOREIGN KEY (`car_id`)
REFERENCES `cars` (`id`);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `full_name` VARCHAR(50) NOT NULL, 
    `phone_number` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);

CREATE TABLE `courses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `from_address_id` INT NOT NULL,
    `start` DATETIME NOT NULL,
    `car_id` INT NOT NULL,
    `client_id` INT NOT NULL,
	`bill` DECIMAL(10, 2) DEFAULT 10,
    CONSTRAINT fk_courses_addresses
    FOREIGN KEY (`from_address_id`)
    REFERENCES `addresses` (`id`),
    CONSTRAINT fk_courses_cars
    FOREIGN KEY (`car_id`)
    REFERENCES `cars` (`id`),
    CONSTRAINT fk_courses_clients
    FOREIGN KEY (`client_id`)
    REFERENCES `clients` (`id`)
);

-- Task 2.    
INSERT INTO `clients`
(`full_name`, `phone_number`)
(SELECT 
	CONCAT(d.`first_name`, ' ', d.`last_name`), 
    CONCAT('(088) 9999', (d.`id` * 2)) 
    FROM `drivers` AS d
    WHERE d.`id` >= 10 AND d.`id` <= 20);
    
-- Task 3.    
UPDATE	`cars` AS c
SET `condition` = 'C'
WHERE c.`mileage` >= 800000 OR c.`mileage` IS NULL AND `year` <= 2010 AND make NOT LIKE 'Mercedes-Benz';

-- Task 4.    
DELETE FROM `clients` AS cl
WHERE cl.`id` NOT IN (SELECT `client_id` FROM `courses` AS co) AND CHAR_LENGTH(cl.`full_name`) > 3; 

-- Task 5.    
SELECT
	`make`,
	`model`,
	`condition`
FROM
	`cars`
ORDER BY
	`cars`.id ASC;

-- Task 6.    
SELECT
	d.`first_name`,
	d.`last_name`, 
	c.`make`,
	c.`model`,
	c.`mileage`
FROM
	`drivers` AS d
INNER JOIN
	`cars_drivers` AS cd
ON
	d.`id` = cd.`driver_id`
INNER JOIN
	`cars` AS c
ON
	cd.`car_id` = c.`id`
WHERE
	c.`mileage` IS NOT NULL
ORDER BY
	c.`mileage` DESC, d.`first_name` ASC;

-- Task 7.    
SELECT
	c.`id` AS `car_id`,
    c.`make`,
    c.`mileage`,
    COUNT(co.`id`) AS `count_of_courses`,
    ROUND(AVG(co.`bill`), 2) AS `avg_bill`
FROM
	`cars` AS c
LEFT JOIN
	`courses` AS co
ON
	c.`id` = co.`car_id`
GROUP BY
	c.`id`
HAVING 
	`count_of_courses` <> 2
ORDER BY
	`count_of_courses` DESC,
    c.`id` ASC;

-- Task 8.    
SELECT
	cl.`full_name`, 
	COUNT(ca.`id`) AS `count_of_cars`,
	SUM(co.`bill`) AS `total_sum`
FROM
	`clients` AS cl
INNER JOIN
	`courses` AS co
ON
	 cl.`id` =co.`client_id`
INNER JOIN
	`cars` AS ca
ON
	co.`car_id` = ca.`id`
WHERE
	SUBSTRING(cl.`full_name`, 2, 1) LIKE 'a'
GROUP BY
	cl.`id`
HAVING 
	`count_of_cars` > 1
ORDER BY
	cl.`full_name` ASC;

-- Task 9. 
SELECT
	ad.`name`,
    IF(HOUR(co.`start`) BETWEEN 6 AND 20, 'Day', 'Night') AS `day_time`,
    co.`bill`,
    cl.`full_name`,
    ca.`make`,
    ca.`model`,
    cat.`name` AS `category_name`
FROM
	`courses` AS co
INNER JOIN
	`addresses` AS ad
ON
	co.`from_address_id` = ad.`id`
INNER JOIN
	`clients` AS cl
ON
	co.`client_id` = cl.`id`
INNER JOIN
	`cars` AS ca
ON
	co.`car_id` = ca.`id`
INNER JOIN
	`categories` AS cat
ON
	ca.`category_id` = cat.`id`
ORDER BY
	co.`id`;
    
-- Task 10. 
DELIMITER $$$
CREATE FUNCTION `udf_courses_by_client` (phone_num VARCHAR (20)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN 
(
	SELECT COUNT(co.`id`)
    FROM
		`courses` AS co
	INNER JOIN
		`clients` as cl
	ON
		co.`client_id` = cl.`id`
	WHERE
		cl.`phone_number` LIKE `phone_num`
);
END $$$
DELIMITER ;

SELECT `udf_courses_by_client` ('(803) 6386812') as `count`; -- 5
SELECT `udf_courses_by_client` ('(831) 1391236') as `count`; -- 3
SELECT `udf_courses_by_client` ('(704) 2502909') as `count`; -- 0

-- Task 11. 
DELIMITER $$$
CREATE PROCEDURE `udp_courses_by_address` (address_name_param VARCHAR(100))
BEGIN
	SELECT
		ad.`name`,
		cl.`full_name`,
        (
        CASE
			WHEN co.`bill` <= 20 THEN 'Low'
            WHEN co.`bill` <= 30 THEN 'Medium'
            ELSE 'High'
        END
         ) AS `level_of_bill`,
        ca.`make`,
        ca.`condition`,
        cat.`name` AS cat_name 
    FROM
		`courses` AS co
	INNER JOIN
		`addresses` AS ad
	ON
		co.`from_address_id` = ad.`id`
	INNER JOIN
		`clients` AS cl
	ON
		co.`client_id` = cl.`id`
	INNER JOIN
		`cars` AS ca
	ON
		co.`car_id` = ca.`id`
	INNER JOIN
		`categories` AS cat
	ON
		ca.`category_id` = cat.`id`
	WHERE
		ad.`name` LIKE `address_name_param`
	ORDER BY
		ca.`make`, `full_name`;
	
END$$$
DELIMITER ;

CALL `udp_courses_by_address`('700 Monterey Avenue'); 