-- First we need to create the soft_uni database from booklibrary.sql file

-- Task 1. Find Names of All Employees by First Name
USE `soft_uni`;

SELECT 
    `first_name`, `last_name`
FROM
    `soft_uni`.`employees`
WHERE
    SUBSTRING(LOWER(`first_name`), 1, 2) = 'sa'
ORDER BY 
	`employee_id` ASC;
    
-- Task 2. Find Names of All Employees by Last Name
SELECT 
    `first_name`, `last_name`
FROM
    `soft_uni`.`employees`
WHERE
    `last_name` LIKE '%ei%'
ORDER BY 
	`employee_id` ASC;

-- Task 3. Find First Names of All Employees
SELECT 
    `first_name`
FROM
    `soft_uni`.`employees`
WHERE
    `department_id` IN (3 , 10)
        AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY 
	`employee_id` ASC;

-- Task 4. Find All Employees Except Engineers
SELECT 
    `first_name`, `last_name`
FROM
    `soft_uni`.`employees`
WHERE
    LOWER(`job_title`) NOT LIKE '%engineer%'
ORDER BY 
	`employee_id` ASC;
	
-- Task 5. Find Towns with Name Length
SELECT 
    `name`
FROM
    `soft_uni`.`towns`
WHERE
    CHAR_LENGTH(`name`) BETWEEN 5 AND 6
ORDER BY 
	`name` ASC;

-- Task 6. Find Towns Starting With
SELECT 
    `town_id`, `name`
FROM
    `soft_uni`.`towns`
WHERE
    LEFT(LOWER(`name`), 1) IN ('m' , 'k', 'b', 'e')
ORDER BY 
	`name` ASC;

-- Task 7. Find Towns Not Starting With
SELECT 
    `town_id`, `name`
FROM
    `soft_uni`.`towns`
WHERE
    LEFT(LOWER(`name`), 1) NOT IN ('r' , 'b', 'd')
ORDER BY 
	`name` ASC;

-- Task 8. Create View Employees Hired After 2000 Year
CREATE VIEW `v_employees_hired_after_2000` AS
    SELECT 
        `first_name`, `last_name`
    FROM
        `soft_uni`.`employees`
    WHERE
        YEAR(`hire_date`) > 2000;
    
SELECT 
    *
FROM
    `v_employees_hired_after_2000`;

-- Task 9. Length of Last Name
SELECT 
    `first_name`, `last_name`
FROM
    `soft_uni`.`employees`
WHERE
    CHAR_LENGTH(`last_name`) = 5;
    
-- First we need to create the geography database from geography.sql file

-- Task 10. Countries Holding 'A' 3 or More Times
USE `geography`;

SELECT 
    `country_name`, `iso_code`
FROM
    `geography`.`countries`
WHERE
    LOWER(`country_name`) LIKE '%a%a%a%'
ORDER BY 
	`iso_code` ASC;

-- Task 11. Mix of Peak and River Names
SELECT 
    `peak_name`,
    `river_name`,
    CONCAT(LOWER(`peak_name`),
            SUBSTRING(`river_name`,
                2,
                CHAR_LENGTH(`river_name`) - 1)) AS `mix`
FROM
    `geography`.`peaks`,
    `geography`.`rivers`
WHERE
    LOWER(RIGHT(`peak_name`, 1)) LIKE LOWER(LEFT(`river_name`, 1))
ORDER BY 
	`mix` ASC; 
    
-- First we need to create the diablo database from diablo.sql file

-- Task 12. Games from 2011 and 2012 Year
USE `diablo`;

SELECT
	`name`, 
    DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM
	`diablo`.`games`
WHERE
	YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY
	`start` ASC, `name` ASC
LIMIT
	50;
	
-- Task 13. User Email Providers
SELECT 
    `user_name`,
    SUBSTRING(`email` FROM LOCATE('@', `email`, 1) + 1) AS `Email Provider`
FROM
    `diablo`.`users`
ORDER BY 
	`Email Provider` ASC , `user_name` ASC;

-- Task 14. Get Users with IP Address Like Pattern
SELECT 
    `user_name`, `ip_address`
FROM
    `diablo`.`users`
WHERE
	`ip_address` LIKE '___.1%.%.___'
ORDER BY
	`user_name` ASC;
    
-- Task 15. Show All Games with Duration and Part of the Day

