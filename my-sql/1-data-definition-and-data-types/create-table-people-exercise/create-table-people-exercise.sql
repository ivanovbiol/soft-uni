CREATE SCHEMA `database`;

USE `database`;

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

INSERT INTO `database`.`people` 
VALUES
(1, 'Ivan Ivanov', NULL, 1.83, 97.52, 'M', '2000-04-15', 'Some biography');

SELECT * FROM `database`.`people`; 
