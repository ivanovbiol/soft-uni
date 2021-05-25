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