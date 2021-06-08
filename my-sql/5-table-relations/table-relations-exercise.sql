-- Task 1. One-To-One Relationship
CREATE DATABASE `people`;

USE `people`;

CREATE TABLE `passports`(
	`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(20) NOT NULL
);

ALTER TABLE `passports` AUTO_INCREMENT = 101;

INSERT INTO `passports` 
(`passport_number`)
VALUES
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

CREATE TABLE `people` (
	`person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(10, 2),
    `passport_id` INT NOT NULL UNIQUE,
    CONSTRAINT fk_people_passports
    FOREIGN KEY (`passport_id`)
    REFERENCES `passports`(`passport_id`)
);

INSERT INTO `people` 
(`first_name`, `salary`, `passport_id`)
VALUES
('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

-- Task 2. One-To-Many Relationship
CREATE DATABASE `automobiles`;

USE `automobiles`;

CREATE TABLE `manufacturers`(
	`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `established_on` DATE
);

INSERT INTO `manufacturers`
(`name`, `established_on`)
VALUES
('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

CREATE TABLE `models`(
	`model_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `manufacturer_id` INT NOT NULL,
    CONSTRAINT fk_models_manufacturers
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `manufacturers`(`manufacturer_id`)
);

ALTER TABLE `models` AUTO_INCREMENT = 101;

INSERT INTO `models`
(`name`, `manufacturer_id`)
VALUES
('X1', 1),
('i6', 1),
('Model S', 2),
('Model X', 2),
('Model 3', 2),
('Nova', 3);

-- Task 3. Many-To-Many Relationship
CREATE DATABASE `training`;

USE `training`;

CREATE TABLE `students`(
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

INSERT INTO `students`
(`name`)
VALUES
('Mila'),
('Toni'),
('Ron');

CREATE TABLE `exams`(
	`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

ALTER TABLE `exams` AUTO_INCREMENT = 101;

INSERT INTO `exams` 
(`name`)
VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

CREATE TABLE `students_exams`(
	`student_id` INT NOT NULL,
    `exam_id` INT NOT NULL,
    CONSTRAINT pk_students_exams
    PRIMARY KEY (`student_id`, `exam_id`),
    CONSTRAINT fk_students_exams_students
    FOREIGN KEY (`student_id`)
    REFERENCES `students`(`student_id`),
    CONSTRAINT fk_students_exams_exams
    FOREIGN KEY (`exam_id`)
    REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams`
VALUES
(1,	101),
(1, 102),
(2, 101),
(3,	103),
(2,	102),
(2,	103);

-- Task 4. Self-Referencing
CREATE DATABASE `teachers`;

USE `teachers`;

CREATE TABLE `teachers`(
	`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `manager_id` INT
);

ALTER TABLE `teachers` AUTO_INCREMENT = 101;

INSERT INTO `teachers`
(`name`, `manager_id`)
VALUES
('John', NULL),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);

ALTER TABLE `teachers`
ADD CONSTRAINT fk_teachers_teachers
FOREIGN KEY (`manager_id`)
REFERENCES `teachers` (`teacher_id`); 