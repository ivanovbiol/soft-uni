-- Task 1.
CREATE DATABASE `softuni_stores_system`; 

USE `softuni_stores_system`;

CREATE TABLE `pictures` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `url` VARCHAR(100) NOT NULL,
    `added_on` DATETIME NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    `best_before` DATE,
    `price` DECIMAL(10, 2) NOT NULL,
    `description` TEXT,
    `category_id` INT NOT NULL,
    `picture_id` INT NOT NULL,
    CONSTRAINT fk_products_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`),
    CONSTRAINT fk_products_pictures
    FOREIGN KEY (`picture_id`)
    REFERENCES `pictures` (`id`)
);

CREATE TABLE `products_stores`(
	`product_id` INT NOT NULL,
    `store_id` INT NOT NULL,
    CONSTRAINT fk_products_stores_products
    FOREIGN KEY (`product_id`)
    REFERENCES `products` (`id`)
);

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (`town_id`)
    REFERENCES `towns` (`id`)
);

CREATE TABLE `stores` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL UNIQUE,
    `rating` FLOAT NOT NULL,
    `has_parking` BOOLEAN DEFAULT FALSE,
    `address_id` INT NOT NULL,
    CONSTRAINT fk_stores_addresses
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses` (`id`)
);

ALTER TABLE `products_stores`
ADD CONSTRAINT pk_products_stores
PRIMARY KEY (`product_id`, `store_id`),
ADD CONSTRAINT fk_products_stores_stores
FOREIGN KEY (`store_id`)
REFERENCES `stores` (`id`);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(15) NOT NULL,
    `middle_name` CHAR(1),
    `last_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(19, 2) DEFAULT 0,
    `hire_date` DATE NOT NULL,
    `manager_id` INT,
    `store_id` INT NOT NULL,
    CONSTRAINT fk_employees_employees
    FOREIGN KEY (`manager_id`)
    REFERENCES `employees` (`id`),
    CONSTRAINT fk_employees_stores
    FOREIGN KEY  (`store_id`)
    REFERENCES `stores` (`id`)
);

-- Task 2.
INSERT INTO products_stores 
	(`product_id`, `store_id`)
SELECT
	p.`id`, 1
FROM
	products AS p
WHERE p.id NOT IN (SELECT `product_id` FROM `products_stores`);

-- Task 3.
UPDATE `employees` AS e
LEFT JOIN
	stores AS s
ON e.`store_id` = s.`id`
SET e.`salary` = e.`salary` - 500, e.`manager_id` = 3
WHERE
	s.`name` NOT IN ('Cardguard', 'Veribet') AND 
    YEAR(e.`hire_date`) > 2003;

-- Task 4.
DELETE 
FROM 
	`employees` 
WHERE 	
	`salary` >= 6000 AND
	`manager_id` IS NOT NULL AND
    `id` NOT IN (SELECT `manager_id`);
	
-- Task 5.
SELECT
	`first_name`,
	`middle_name`,
	`last_name`,
	`salary`,
	`hire_date`
FROM
	`employees`
WHERE
	`salary` IS NOT NULL
ORDER BY
	`hire_date` DESC;

-- Task 6.
SELECT
	p.`name`,
	p.`price`, 
	p.`best_before`,
	CONCAT(SUBSTRING(p.`description`,1, 10), '...') AS `short_description`,  
	pic.`url`
FROM
	`products` AS p
INNER JOIN
	`pictures` AS pic
ON
	p.`picture_id` = pic.`id`
WHERE
	CHAR_LENGTH(p.`description`) > 100 AND
    YEAR(pic.`added_on`) < 2019 AND
    p.`price` > 20
ORDER BY
	p.`price` DESC;

-- Task 7.
SELECT
	s.`name`,
    COUNT(p.`id`) AS `product_count`,
    ROUND(AVG(p.`price`), 2) AS `avg`
FROM
	`stores` AS s
LEFT JOIN
	`products_stores` AS ps
ON
	s.`id` = ps.`store_id`
LEFT JOIN
	`products` AS p
ON
	ps.`product_id` = p.`id`
GROUP BY
	s.`name`
ORDER BY
	`product_count` DESC,
	`avg` DESC,
    s.`id`;

-- Task 8.
SELECT
	CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `Full name`,
	s.`name` AS `Store name`, 
	a.`name` AS `Address`,
	e.`salary` AS `Salary`
FROM
	`employees` AS e
INNER JOIN
	`stores` AS s
ON
	e.`store_id` = s.`id`
INNER JOIN
	`addresses` AS a
ON
	s.`address_id` = a.`id`
WHERE
	e.`salary` < 4000 AND
    a.`name` LIKE '%5%' AND
    CHAR_LENGTH(s.`name`) > 8 AND
    e.`last_name` LIKE '%n';

-- Task 9.
SELECT
	REVERSE(s.`name`) AS `reversed_name`,
	CONCAT(UPPER(t.`name`), '-', a.`name`) AS `full_address`,
	COUNT(e.`id`) AS `employees_count`
FROM
	`stores` AS s
INNER JOIN
	`addresses` AS a
ON
	s.`address_id` = a.`id`
INNER JOIN
	`towns` AS t
ON
	a.`town_id` = t.`id`
INNER JOIN
	`employees` AS e
ON
	e.`store_id` = s.`id`
GROUP BY
	s.`name`
HAVING
	`employees_count` > 0
ORDER BY
	`full_address` ASC;

-- Task 10.
DELIMITER $$$
CREATE FUNCTION `udf_top_paid_employee_by_store`(store_name VARCHAR(50))
RETURNS TEXT
DETERMINISTIC
BEGIN

RETURN ( 
	SELECT
		CONCAT(
			e.`first_name`, ' ',
            e.`middle_name`, '. ',
            e.`last_name`, ' ',
			'works in store for ',
            (YEAR('2020-10-18') - YEAR(e.`hire_date`)), 
            ' years')
	FROM
		`employees` AS e
	INNER JOIN
		`stores` AS s
	ON
		e.`store_id` = s.`id`
	WHERE
		s.`name` LIKE store_name
	ORDER BY
		e.`salary` DESC
	LIMIT 1
);
END $$$

DELIMITER ;
	
SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

DROP FUNCTION udf_top_paid_employee_by_store;

-- Task 11.
DELIMITER $$$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
	UPDATE products AS p
    SET p.`price` = p.`price` + IF(address_name LIKE '0%', 100, 200)
    WHERE p.`id` IN 
		(SELECT ps.`product_id` 
        FROM `products_stores` AS ps -- ON p.`id` = ps.`product_id`
		INNER JOIN `stores` AS s ON ps.`store_id` = s.`id`
		INNER JOIN `addresses` AS a ON s.`address_id` = a.`id`
		WHERE a.`name` LIKE address_name);
END $$$

DELIMITER ;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;