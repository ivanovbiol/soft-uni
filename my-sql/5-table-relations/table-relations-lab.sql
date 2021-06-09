-- Task 1. Mountains and Peaks
CREATE DATABASE `geography`;

USE `geography`;

CREATE TABLE `mountains` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);

CREATE TABLE `peaks` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT fk_peaks_mountains
    FOREIGN KEY (`mountain_id`)
    REFERENCES `geography`.`mountains` (`id`)
);

-- First we need to create the camp database from camp-database.sql file

-- Task 2. Trip Organization
SELECT
	v.`driver_id` AS `Driver ID`,
    v.`vehicle_type` AS `Vehicle Type`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `Driver Name`
FROM
	`camp`.`vehicles` AS v
LEFT JOIN
	`camp`.`campers` AS c
ON 
	v.`driver_id` = c.`id`;

-- Task 3. SoftUni Hiking
SELECT
	r.`starting_point` AS `Route Starting Point`,
    r.`end_point` AS `Route End Point`,
    r.`leader_id` AS `Leader ID`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `Leader Name`
FROM
	`camp`.`routes` AS r
LEFT JOIN
	`camp`.`campers` AS c
ON
	r.`leader_id` = c.`id`;