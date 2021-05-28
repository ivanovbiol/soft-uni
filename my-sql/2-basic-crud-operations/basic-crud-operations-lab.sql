-- Database creation and data import
CREATE DATABASE IF NOT EXISTS `hotel`; 
USE `hotel`;

CREATE TABLE `departments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50)
);

INSERT INTO `hotel`.`departments`
	(`name`) 
VALUES
	('Front Office'), 
	('Support'), 
	('Kitchen'), 
	('Other');

SELECT * FROM `hotel`.`departments`;

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`job_title` VARCHAR(50) NOT NULL,
	`department_id` INT NOT NULL,
	`salary` DOUBLE NOT NULL,
	CONSTRAINT `fk_department_id` 
    FOREIGN KEY (`department_id`) 
    REFERENCES `departments` (`id`)
);

INSERT INTO `employees` 
	(`first_name`,`last_name`, `job_title`,`department_id`,`salary`) 
VALUES
	('John', 'Smith', 'Manager',1, 900.00),
	('John', 'Johnson', 'Customer Service',2, 880.00),
	('Smith', 'Johnson', 'Porter', 4, 1100.00),
	('Peter', 'Petrov', 'Front Desk Clerk', 1, 1100.00),
	('Peter', 'Ivanov', 'Sales', 2, 1500.23),
	('Ivan' ,'Petrov', 'Waiter', 3, 990.00),
	('Jack', 'Jackson', 'Executive Chef', 3, 1800.00),
	('Pedro', 'Petrov', 'Front Desk Supervisor', 1, 2100.00),
	('Nikolay', 'Ivanov', 'Housekeeping', 4, 1600.00);
	
SELECT * FROM `hotel`.`employees`;

CREATE TABLE `rooms` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`type` VARCHAR(30)
);

INSERT INTO `rooms`
	(`type`) 
VALUES
	('apartment'), 
    ('single room');

SELECT * FROM `hotel`.`rooms`;

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50),
	`last_name` VARCHAR(50),
	`room_id` INT NOT NULL,
    CONSTRAINT `fk_clients_rooms`
    FOREIGN KEY (`room_id`)
    REFERENCES `rooms` (`id`)
);

INSERT INTO `hotel`.`clients`
	(`first_name`,`last_name`,`room_id`) 
VALUES
	('Pesho','Petrov', 1),
    ('Gosho','Georgiev', 2),
	('Mariya','Marieva', 2), 
	('Katya','Katerinova', 1), 
    ('Nikolay','Nikolaev', 2);
    
    
SELECT * FROM `hotel`.`clients`;

-- Task 1. Select Employee Information
SELECT 
	`id`, `first_name`, `last_name`, `job_title`
FROM
	`hotel`.`employees`
ORDER BY `id`;

-- Task 2. Select Employees with Filter
SELECT
	`id`, concat_ws(' ', `first_name`, `last_name`) AS`full_name`, `job_title`, `salary`
 FROM
	`hotel`.`employees`
WHERE `salary` > 1000.00
ORDER BY `id` ASC; 

-- Task 3. Update Employees Salary
UPDATE 
	`hotel`.`employees`
SET 
	`salary` = `salary` + 100
WHERE 
	`job_title` = 'Manager';

-- Task 4. Top Paid Employee
SELECT * FROM `hotel`.`employees`
ORDER BY `salary` DESC
LIMIT 1;
 
-- Task 5. Select Employees by Multiple Filters
SELECT * FROM `hotel`.`employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id` ASC;

-- Task 6. Delete from Table
DELETE FROM `hotel`.`employees` 
WHERE 
	`department_id` = 1 OR `department_id` = 2;
    
SELECT * FROM `hotel`.`employees`
ORDER BY `id` ASC;