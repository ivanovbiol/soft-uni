CREATE DATABASE `temporary`;

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(33) NOT NULL,
    `last_name` VARCHAR(33) NOT NULL
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(33) NOT NULL
);

