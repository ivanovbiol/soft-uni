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

INSERT INTO `directors` 
VALUES 
(1, 'Pesho The Director', 'Some notes for the direstor'),
(2, 'Gustav', 'Notes for the direstor'),
(3, 'Director Name', 'Notes');

INSERT INTO `genres`
VALUES
(1, 'Drama', NULL),
(2, 'Action', 'Notes for the action genre'),
(3, 'Documentary', NULL);

INSERT INTO `categories`
VALUES
(1, 'Best', NULL),
(2, 'Average', 'Some Notes for the category'),
(3, 'Worst', 'Notes');

INSERT INTO `movies`
VALUES
(1, 'First movie Title', 1, '2001/05/04', '02:13:45', 1, 1, 7.5, 'Some Notes for the movie'),
(2, 'Second movie Title', 2, NULL, NULL, 2, 2, 14.23, NULL),
(3, 'Third movie Title', 3, NULL, '01:45:32', 3, 3, 2.786, 'Notes');

SELECT * FROM `movies`;