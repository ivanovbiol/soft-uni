-- Task 1. Create Database and Tables
CREATE SCHEMA `minions`;

USE `minions`;

CREATE TABLE `minions` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(33) NOT NULL,
    `age` INT 
);

CREATE TABLE `towns` (
	`town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(33) NOT NULL
);

-- Task 2. Alter Minions Table
ALTER TABLE `minions`.`towns`
CHANGE COLUMN `town_id` `id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `minions`.`minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY `minions` (`town_id`)
REFERENCES `towns`(`id`); 

-- Task 3. Insert records into tables
INSERT INTO `minions`.`towns`
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

SELECT * FROM `minions`.`towns`;

INSERT INTO `minions`.`minions`
VALUES
(1, 'Pesho', 15, 1),
(2, 'Ivan', 29, 2),
(3, 'Gosho', 34, 3);

SELECT * FROM `minions`.`minions`;

-- Task 4. Truncate table minions
TRUNCATE `minions`.`minions`;

SELECT * FROM `minions`.`minions`;

-- Task 5. Drop all tables
DROP TABLE `minions`.`minions`;
DROP TABLE `minions`.`towns`;

-- Task 6. Create table people and add records
CREATE TABLE `people` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    -- Usually the pictures are being stored on a cloud and only link is provided in the table
    -- in a VARCHAR cell 
    `picture` BLOB,
    -- Specifying numbers of digits for float is deprecated, but the current task requires it
    `height` FLOAT(4, 2),
    `weight` FLOAT(5, 2),
    `gender` CHAR(1) NOT NULL,
    `birthday` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO `minions`.`people`
(`name`, `picture`, `height`, `weight`, `gender`, `birthday`, `biography`)
VALUES 
('Name_One', NULL, 1.82, 97.3, 'M', '1988-12-01', 'Some very long text'),
('Name_Two', NULL, NULL, NULL, 'F', '1992-03-25', 'Some text'),
('Name_Three', NULL, 1.78, 95, 'M', '1996-04-23', NULL);

SELECT * FROM `minions`.`people`;

-- Task 7. Create table users and add records
CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB(900),
    `last_login_time` DATETIME,
    `is_detected` BOOLEAN
);

INSERT INTO `minions`.`users` 
(`username`, `password`, `profile_picture`, `last_login_time`,`is_detected`)
VALUES
('First_Username', 'First_Password', NULL, '2021-05-25', true),
('Second_Username', 'Second_Password', NULL, '2020-12-13', false),
('Third_Username', 'Third_Password', NULL, NULL, NULL);

SELECT * FROM `minions`.`users`;

-- Task 8. Change primary key
ALTER TABLE `minions`.`users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY(`id`, `username`);

SELECT * FROM `minions`.`users`;

-- Task 9. Set default value of a field
ALTER TABLE `minions`.`users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();

SELECT * FROM `minions`.`users`;

-- Task 10. Set unique field
ALTER TABLE `minions`.`users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (`id`),
ADD CONSTRAINT `username` UNIQUE (`username`);

-- Task 11.	Create movies database
CREATE DATABASE `movies`;

USE `movies`;

CREATE TABLE `directors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(15) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(15) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(30) NOT NULL,
    `director_id` INT NOT NULL,
    `copyright_year` DATE,
    `length` TIME,
    `genre_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `rating` FLOAT NOT NULL,
    `notes` TEXT,
    CONSTRAINT fk_movies_directors
    FOREIGN KEY (`director_id`) REFERENCES `directors`(`id`),
    CONSTRAINT fk_movies_genres
    FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`),
    CONSTRAINT fk_movies_caterogy
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

INSERT INTO `movies`.`directors`
( `director_name`, `notes`) 
VALUES 
('Pesho The Director', 'Some notes for the direstor'),
('Gustav', 'Notes for the direstor'),
('Director Name', 'Notes');

INSERT INTO `movies`.`genres`
(`genre_name`, `notes`)
VALUES
('Drama', NULL),
('Action', 'Notes for the action genre'),
('Documentary', NULL);

INSERT INTO `movies`.`categories`
(`category_name`, `notes`)
VALUES
('Best', NULL),
('Average', 'Some Notes for the category'),
('Worst', 'Notes');

INSERT INTO `movies`.`movies`
( `title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES
('First movie Title', 1, '2001/05/04', '02:13:45', 1, 1, 7.5, 'Some Notes for the movie'),
('Second movie Title', 2, NULL, NULL, 2, 2, 14.23, NULL),
('Third movie Title', 3, NULL, '01:45:32', 3, 3, 2.786, 'Notes');

SELECT * FROM `movies`;

-- Task 12.	Create car rental database
CREATE SCHEMA `car_rental`;

USE `car_rental`;

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(15) NOT NULL,
    `daily_rate` DECIMAL(4, 2),
    `weekly_rate` DECIMAL(4, 2),
    `monthly_rate` DECIMAL(4, 2),
    `weekend_rate` DECIMAL(4, 2)
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `plate_number` VARCHAR(8) NOT NULL,
    `mark` VARCHAR(8) NOT NULL,
    `model` VARCHAR(8) NOT NULL,
    `car_year` INT NOT NULL,
    `category_id` INT NOT NULL,
    `doors` INT NOT NULL,
    `picture` BLOB,
    `car_condition` VARCHAR(15) NOT NULL,
    `available` BOOLEAN NOT NULL,
    CONSTRAINT fk_cars_cars
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `title` VARCHAR(50),
    `notes` TEXT
);

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `driver_licence_number` VARCHAR(8) NOT NULL,
    `full_name` VARCHAR(30) NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `city` VARCHAR(15) NOT NULL,
    `zpi_code` INT,
    `notes` TEXT
);

CREATE TABLE `rental_orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `car_id` INT NOT NULL,
    `car_condition` VARCHAR(15) NOT NULL,
    `tank_level` INT,
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` INT,
    `rate_applied` INT,
    `tax_rate` DECIMAL(5, 2),
    `order_status` VARCHAR(10) NOT NULL,
    `notes` TEXT,
    CONSTRAINT fk_rental_orders_employees
    FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
    CONSTRAINT fk_rental_orders_customers
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
    CONSTRAINT fk_rental_orders_cars
    FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`)
);
