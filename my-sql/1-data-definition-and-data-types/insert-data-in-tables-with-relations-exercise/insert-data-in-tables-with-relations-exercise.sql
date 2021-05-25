CREATE DATABASE `soft_uni`;

USE `soft_uni`;

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(100) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`) 
);

CREATE TABLE `departments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50),
    `last_name` VARCHAR(50) NOT NULL,
    `job_title` VARCHAR(50),
    `department_id` INT NOT NULL,
    `hire_date` DATE,
    `salary` DECIMAL(10, 2),
    `address_id` INT NOT NULL,
    CONSTRAINT fk_employees_departments
    FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
    CONSTRAINT fk_employees_addresses
    FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

INSERT INTO `towns` 
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna'),
(4, 'Burgas');

INSERT INTO `departments`
VALUES
(1, 'Engineering'),
(2, 'Sales'),
(3, 'Marketing'),
(4, 'Software Development'),
(5, 'Quality Assurance');

INSERT INTO `addresses`
VALUES
(1, 'Some street', 1),
(2, 'Street', 2),
(3, 'Some street and a number', 3),
(4, 'Adress and a number', 4);

INSERT INTO `employees`
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', 'Java Dev', 4, '2021-05-25', 4500.52, 2),
(2, 'Pesho', 'Peshov', 'Peshov', 'QA', 5, NULL, 2567.74, 1),
(3, 'Gosho', 'Goshov', 'Goshov', 'Sales Expert', 2, '2021-04-13', NULL, 3),
(4, 'Atanas', NULL, 'Atanasov', NULL, 3, '2021-01-11', NULL, 4);

-- To view the records
SELECT * FROM `employees`;