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