-- First we need to create the the soft_uni database from the soft-uni-database.sql file
 
-- Task 1. Find All Information About Departments
USE `soft_uni`;
 
SELECT 
	* 
FROM 
	`soft_uni`.`departments`
ORDER BY 
	`department_id` ASC;

-- Task 2. Find all Department Names 
SELECT 
	`name` 
FROM 
	`soft_uni`.`departments`
ORDER BY 
	`department_id` ASC;

-- Task 3. Find salary of Each Employee 
SELECT
	`first_name`, `last_name`, `salary`
FROM
	`soft_uni`.`employees`
ORDER BY 
	`employee_id` ASC;
    
-- Task 4. Find Full Name of Each Employee 
SELECT
	`first_name`, `middle_name`, `last_name`
FROM
	`soft_uni`.`employees`
ORDER BY 
	`employee_id` ASC;
    
-- Task 5. Find Email Address of Each Employee 
SELECT
	concat(`first_name`, '.', `last_name`, '@softuni.bg')
    AS `full_email_address`
FROM
	`soft_uni`.`employees`;

-- Task 6. Find All Different Employee's Salaries 
SELECT DISTINCT
	`salary`
FROM 
	`soft_uni`.`employees`
ORDER BY 
	`employee_id`;

-- Task 7. Find all Information About Employees 
SELECT 
	*
FROM 
	`soft_uni`.`employees`
WHERE
	`job_title` = 'Sales Representative'
ORDER BY
	`employee_id` ASC;

-- Task 8. Find Names of All Employees by salary in Range 
SELECT
	`first_name`, `last_name`, `job_title` 
FROM
	`soft_uni`.`employees`
WHERE
	`salary` BETWEEN 20000 AND 30000
ORDER BY 
	`employee_id` ASC;
    
-- Task 9. Find Names of All Employees  
SELECT
	concat_ws(' ', `first_name`, `middle_name`, `last_name`)
    AS `full name`
FROM
	`soft_uni`.`employees`
WHERE
	`salary` IN (25000, 14000, 12500, 23600)
ORDER BY 
	`employee_id` ASC;
    
-- Task 10. Find All Employees Without Manager 
SELECT
	`first_name`, `last_name`
FROM
	`soft_uni`.`employees`
WHERE 
	`manager_id` IS NULL
ORDER BY
	`employee_id` ASC;
    
-- Task 11. Find All Employees with salary More Than 50000 
SELECT
	`first_name`, `last_name`, `salary`
FROM 
	`soft_uni`.`employees`
WHERE 
	`salary` > 50000
ORDER BY
	`salary` DESC;
	
-- Task 12. Find 5 Best Paid Employees 
SELECT
	`first_name`, `last_name`
FROM 
	`soft_uni`.`employees`
ORDER BY
	`salary` DESC
LIMIT 5;
	
-- Task 13. Find All Employees Except Marketing 
SELECT
	`first_name`, `last_name`
FROM 
	`soft_uni`.`employees`
WHERE
	`department_id` != 4
ORDER BY
	`employee_id` ASC;
    
-- Task 14. Sort Employees Table 
SELECT
	*
FROM
	`soft_uni`.`employees`
ORDER BY
	`salary` DESC, `first_name` ASC, `last_name` DESC, `middle_name` DESC;
    
-- Task 15. Create View Employees with Salaries 
CREATE VIEW
	`v_employees_salaries`
AS 
SELECT 
	`first_name`, `last_name`, `salary`
FROM
	`soft_uni`.`employees`;
    
SELECT	
	*
FROM
	`v_employees_salaries`;

-- Task 16. Create View Employees with Job Titles 
CREATE VIEW
	`v_employees_job_titles`
AS
SELECT
	concat_ws(' ', `first_name`, IFNULL(`middle_name`, ''), `last_name`) AS `full name`,
    `job_title`
FROM 
	`soft_uni`.`employees`;

SELECT
	* 
FROM 
	`v_employees_job_titles`;

-- Task 17. Distinct Job Titles 
SELECT DISTINCT
	`job_title`
FROM
	`soft_uni`.`employees`
ORDER BY
	`job_title` ASC;

-- Task 18. Find First 10 Started Projects 
SELECT
	*
FROM
	`soft_uni`.`projects`
ORDER BY
	`start_date` ASC, `name` ASC
LIMIT 10;

-- Task 19. Last 7 Hired Employees 
SELECT
	`first_name`, `last_name`, `hire_date`
FROM
	`soft_uni`.`employees`
ORDER BY
	`hire_date` DESC
LIMIT 7;

-- Task 20. Increase Salaries
UPDATE
	`soft_uni`.`employees`
SET
	`salary` = `salary` * 1.12
WHERE 
	`department_id` IN (1, 2, 4, 11);

SELECT
	`salary`
FROM
	`soft_uni`.`employees`;
    
-- First we need to create the geography database from the geography-database.sql file

-- Task 21. All Mountain Peaks 
USE `geography`;

SELECT
	`peak_name`
FROM
	`geography`.`peaks`
ORDER BY
	`peak_name` ASC;

-- Task 22. Biggest Countries by Population 
SELECT
	`country_name`, `population`
FROM
	`geography`.`countries`
WHERE
	`continent_code` = 'EU'
ORDER BY
	`population` DESC, `country_name` ASC
LIMIT 30;

-- Task 23. Countries and Currency (Euro / Not Euro) 
SELECT
	`country_name`, `country_code`,
    CASE
        WHEN currency_code = 'EUR' THEN 'Euro'
        ELSE 'Not Euro'
    END AS currency
FROM
	`geography`.`countries`
ORDER BY
	`country_name` ASC;

-- First we need to create the diablo database from the diablo-database.sql file

-- Task 24. All Diablo Characters 
USE `diablo`;

SELECT
	`name`
FROM
	`diablo`.`characters`
ORDER BY
	`name` ASC;