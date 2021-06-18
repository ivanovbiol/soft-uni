-- Task 1.

CREATE DATABASE `fsd`;

USE `fsd`;

CREATE TABLE `players` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `age` INT NOT NULL DEFAULT 0,
    `position` CHAR(1) NOT NULL,
    `salary` DECIMAL(10, 2) NOT NULL DEFAULT 0,
    `hire_date` DATETIME,
    `skills_data_id` INT NOT NULL,
    `team_id` INT
);

CREATE TABLE `players_coaches` (
	`player_id` INT NOT NULL,
    `coach_id` INT NOT NULL, 
    CONSTRAINT pk_players_coaches_players
    FOREIGN KEY (`player_id`)
    REFERENCES `players` (`id`)
);

CREATE TABLE `coaches` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(10, 2) NOT NULL DEFAULT 0,
    `coach_level` INT NOT NULL DEFAULT 0
);

ALTER TABLE `players_coaches`
ADD CONSTRAINT pk_players_coaches_coaches
FOREIGN KEY (`coach_id`)
REFERENCES `coaches` (`id`);

CREATE TABLE `skills_data` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `dribbling` INT DEFAULT 0,
    `pace` INT DEFAULT 0,
    `passing` INT DEFAULT 0,
    `shooting` INT DEFAULT 0,
    `speed` INT DEFAULT 0,
    `strength` INT DEFAULT 0
);

ALTER TABLE `players`
ADD CONSTRAINT pk_players_skills_data
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data` (`id`);

CREATE TABLE `countries` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
	CONSTRAINT pk_towns_countries
    FOREIGN KEY (`country_id`)
    REFERENCES `countries` (`id`)
);

CREATE TABLE `stadiums` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `capacity` INT NOT NULL,
    `town_id` INT NOT NULL,
	CONSTRAINT fk_stadiums_towns
    FOREIGN KEY (`town_id`)
    REFERENCES `towns` (`id`)
);

CREATE TABLE `teams` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `established` DATE NOT NULL,
    `fan_base` BIGINT NOT NULL DEFAULT 0,
    `stadium_id` INT NOT NULL,
	CONSTRAINT fk_teams_stadiums
    FOREIGN KEY (`stadium_id`)
    REFERENCES `stadiums` (`id`)
);

ALTER TABLE `players`
ADD CONSTRAINT fk_players_teams
FOREIGN KEY (`team_id`)
REFERENCES `teams` (`id`);

-- Task 2.
INSERT INTO `coaches`
(`first_name`, `last_name`, `salary`, `coach_level`)
(SELECT 
	`first_name`, `last_name`, `salary` * 2, CHAR_LENGTH(`first_name`)
FROM
	`players`
WHERE
	`age` >= 45);

-- Task 3.
UPDATE `players` AS p
INNER JOIN `players_coaches` AS pc
ON p.`id` = pc.`player_id`
INNER JOIN `coaches` AS c
ON pc.`coach_id` = c.`id`
SET c.`coach_level` = c.`coach_level` + 1
WHERE c.`first_name` LIKE ('A%');

-- Task 4.
DELETE 
FROM `players`
WHERE
	`age` >= 45;

-- Task 5.
SELECT
	`first_name`,
	`age`,
    `salary`
FROM
	`players`
ORDER BY
	`salary` DESC;

-- Task 6.
SELECT
	p.`id`,
	CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`,
	p.`age`,
	p.`position`,
	p.`hire_date`
FROM
	`players` AS p
INNER JOIN
		`skills_data` AS sd
ON 
	p.`skills_data_id` = sd.`id`
WHERE
	p.`age` < 23 AND
    p.`position` LIKE 'A' AND
    p.`hire_date` IS NULL AND 
    sd.`strength` > 50
ORDER BY
	p.`salary` ASC,
    p.`age` ASC;
    
-- Task 7.
SELECT 
    `name` AS `team_name`,
    `established`,
    `fan_base`,
    (SELECT 
            COUNT(p.`id`)
        FROM
            `players` AS p
		INNER JOIN `teams` AS t 
        ON p.`team_id` = t.`id`
        WHERE t.`name` LIKE `team_name`) AS `count_of_players`
FROM
	`teams`
ORDER BY
	`count_of_players` DESC,
    `fan_base` DESC;
    
-- Task 8.
SELECT
	MAX(sd.`speed`) AS `max_speed`,
    tw.`name` AS `town_name`
FROM
	`players` AS p
INNER JOIN 
	`skills_data` AS sd 
ON 
	p.`skills_data_id` = sd.`id`
RIGHT JOIN
	`teams` AS t
ON
	p.`team_id` = t.`id`
RIGHT JOIN
	`stadiums` AS s
ON
	t.`stadium_id` = s.`id`
RIGHT JOIN
	`towns` AS tw
ON
	s.`town_id` = tw.`id`
WHERE
	t.`name` NOT LIKE 'Devify'    
GROUP BY
	tw.`name`
ORDER BY
	`max_speed` DESC, tw.`name` ASC;

-- Task 9.
SELECT
	c.`name`,
    COUNT(p.`id`) AS `total_count_of_players`,
    SUM(p.`salary`) AS `total_sum_of_salaries`
FROM
	`players` AS p
RIGHT JOIN
	`teams` AS t
ON 
	p.`team_id` = t.`id`
RIGHT JOIN
	`stadiums` AS s
ON
	t.`stadium_id` = s.`id`
RIGHT JOIN
	`towns` AS tw
ON
	s.`town_id` = tw.`id`
RIGHT JOIN
	`countries` AS c
ON
	tw.`country_id` = c.`id`
GROUP BY
	c.`name`
ORDER BY
	`total_count_of_players` DESC,
    c.`name` ASC;


-- Task 10.
DELIMITER $$$
CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30)) 
RETURNS INTEGER
DETERMINISTIC

BEGIN

RETURN 
(SELECT
	COUNT(p.`id`)
	FROM
     players AS p
        INNER JOIN
    teams AS t ON p.team_id = t.id
        INNER JOIN
    stadiums AS s ON t.stadium_id = s.id
    WHERE
		s.`name` LIKE stadium_name
);
END $$$

DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`; 
SELECT udf_stadium_players_count ('Linklinks') as `count`; 

-- Task 11.
DELIMITER $$$
CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points INTEGER, team_name VARCHAR(45))
BEGIN
	SELECT
		CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`,
        p.`age`,
        p.`salary`,
        sd.`dribbling`,
        sd.`speed`,
        t.`name`
	FROM
		`players` AS p
	INNER JOIN
		`skills_data` AS sd
	ON
		p.`skills_data_id` = sd.`id`
	INNER JOIN
		`teams` AS t
	ON
		p.`team_id` = t.`id` 
	WHERE
		 sd.`dribbling` > min_dribble_points AND
         t.`name` LIKE team_name
	ORDER BY
		 sd.`speed` DESC
	LIMIT 1;
         
END $$$

DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');

 
 
 
 
 
