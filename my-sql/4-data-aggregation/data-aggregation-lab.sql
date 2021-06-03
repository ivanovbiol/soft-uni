-- First we need to create the restaurant database from restaurant.sql file

-- Task 1. Departments Info
USE `restaurant`;

SELECT
	`department_id`,
    COUNT(`id`) AS `Number of employees`
FROM
	`restaurant`.`employees`
GROUP BY 
	`employees`.`department_id`
ORDER BY 
	`department_id` ASC, 
    `Number of employees` ASC;
    
-- Task 2. Average Salary
SELECT
	`department_id`,
    ROUND(AVG(`salary`), 2) AS `Average Salary`
FROM 
	`restaurant`.`employees`
GROUP BY
	`department_id`
ORDER BY
	`department_id` ASC;

-- Task 3. Min Salary
SELECT
	`department_id`,
    ROUND(MIN(`salary`), 2) AS `Min Salary`
FROM 
	`restaurant`.`employees`
GROUP BY
	`department_id`
HAVING
	`Min Salary` > 800
ORDER BY
	`department_id` ASC;

-- Task 4. Appetizers Count
SELECT
	COUNT(`category_id`) AS `Apetizers count`
FROM
	`restaurant`.`products`
WHERE
	`category_id` = 2 AND `price` > 8;
	
-- Task 5. Menu Prices
SELECT
	`category_id`,
    ROUND(AVG(price), 2) AS `Average Price`,
    ROUND(MIN(price), 2) AS `Cheapest Product`,
    ROUND(MAX(price), 2) AS `Most Expensive Product`
FROM
	`restaurant`.`products`
GROUP BY
	`category_id`
ORDER BY 
	`category_id` ASC;