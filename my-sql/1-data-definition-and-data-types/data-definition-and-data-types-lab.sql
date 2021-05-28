-- Task 1. Create Tables
CREATE DATABASE `test_database`;

USE `test_database`;

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(33) NOT NULL,
    `last_name` VARCHAR(33) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(33) NOT NULL
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(33) NOT NULL,
    `category_id` INT
);

-- Task 2. Insert Data in Tables
INSERT INTO `test_database`.`employees` (`first_name`, `last_name`)
VALUES 
('Test', 'Testov'),
('Ivan', 'Ivanov'),
('Pesho', 'Peshov');

SELECT * FROM `test_database`.`employees`;

INSERT INTO `test_database`.`categories` (`name`)
VALUES 
('Category_One'),
('Category_Two'),
('Category_Three');

SELECT * FROM `test_database`.`categories`;

INSERT INTO `test_database`.`products` (`name`)
VALUES 
('Product_One'),
('Product_Two'),
('Product_Three');

SELECT * FROM `test_database`.`products`;

-- Task 3. Alter Table `employees`
ALTER TABLE `test_database`.`employees`
ADD COLUMN `middle_name` VARCHAR(33) NOT NULL
AFTER `first_name`;

SELECT * FROM `test_database`.`employees`;

DROP DATABASE `test_database`;
