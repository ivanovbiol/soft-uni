-- First we need to create the soft-uni database from soft-uni-database.sql file

-- Task 1. Managers
USE `soft_uni`;

SELECT
	e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS `Full Name`,
    d.`department_id`,
    d.`name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`departments` AS d 
ON 
	d.`manager_id` = e.`employee_id`
ORDER BY
	e.`employee_id` 
LIMIT 5;

-- Task 2. Towns Addresses
SELECT
	t.`town_id` AS `Town ID`,
    t.`name` AS `Town Name`,
    a.`address_text` AS `Address Text`
FROM
	`soft_uni`.`towns` AS t
LEFT JOIN
	`soft_uni`.`addresses` AS a
ON 
	a.`town_id` = t.`town_id`
WHERE
	t.`name` = 'San Francisco' OR  t.`name` = 'Sofia' OR  t.`name` = 'Carnation'
ORDER  BY
	`Town ID`, a.`address_id`;  

-- Task 3. Employees Without Managers
SELECT
	`employee_id` AS `Employee ID`, 
    `first_name` AS `First Name`, 
    `last_name` AS `Last Name`, 
    `department_id` AS `Departments ID`,
    `salary` AS `Salary`
FROM
	`soft_uni`.`employees`
WHERE
	`manager_id` IS NULL;

-- Task 4. Higher Salary
SELECT
	COUNT(*) AS `Count`
FROM
	`soft_uni`.`employees`
WHERE
	`salary` > (
				SELECT AVG(`salary`)
                FROM `soft_uni`.`employees`);
