-- First we need to create the soft-uni database from soft-uni database.sql file

-- Task 1. Employee Address
USE `soft_uni`;

SELECT 
    e.`employee_id` AS `Employee ID`,
    e.`job_title` AS `Job Title`,
    a.`address_id` AS `Address ID`,
    a.`address_text` AS `Address Text`
FROM
    `soft_uni`.`employees` AS e
INNER JOIN
    `addresses` AS a ON e.`address_id` = a.`address_id`
ORDER BY a.`address_id`
LIMIT 5;

-- Task 2. Addresses with Towns
SELECT
	e.`first_name` AS `First Name`,
    e.`last_name` AS `Last Name`,
    t.`name` AS `Town Name`,
    a.`address_text` AS `Address Text`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`addresses` AS a
ON
	e.`address_id` = a.`address_id`
INNER JOIN
	`soft_uni`.`towns` AS t
ON
	a.`town_id` = t.`town_id`
ORDER BY
	e.`first_name` ASC, e.`last_name` ASC
LIMIT 5;
    
 -- Task 3. Sales Employee
 SELECT
	e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`,
    e.`last_name` AS `Last Name`,
    d.`name` AS `Department Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`departments` AS d
ON
	e.`department_id` = d.`department_id`
WHERE
	d.`name` = 'Sales'
ORDER BY
	e.`employee_id` DESC;

-- Task 4. Employee Departments
SELECT
	e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`,
    e.`salary` AS `Salary`,
    d.`name` AS `Department Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN 
	`soft_uni`.`departments` AS d
ON
	e.`department_id` = d.`department_id`
WHERE
	e.`salary` > 15000
ORDER BY
	d.`department_id` DESC
LIMIT 5;
 
-- Task 5. Employees Without Project
SELECT 
    e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`
FROM
    `soft_uni`.`employees` AS e
LEFT JOIN
    `soft_uni`.`employees_projects` AS ep 
ON 
	e.`employee_id` = ep.`employee_id` 
WHERE
	ep.`project_id` IS NULL
ORDER BY
	e.`employee_id` DESC 
LIMIT 3;

-- Task 6. Employees Hired After
SELECT
	e.`first_name` AS `First Name`,
    e.`last_name` AS `Last Name`,
    e.`hire_date` AS `Hire Date`,
    d.`name` AS `Department Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`departments` AS d
USING
	(`department_id`)
WHERE
	DATE(e.`hire_date`) >= 1999 AND 
    d.`name` = 'Sales' OR d.`name` = 'Finance'
ORDER BY
	e.`hire_date` ASC;

-- Task 7. Employees with Project
SELECT
	e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`,
    p.`name` AS `Project Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`employees_projects` AS ep
ON
	e.`employee_id` = ep.`employee_id`
JOIN
	`soft_uni`.`projects` AS p
ON
	ep.`project_id` = p.`project_id`
WHERE
	DATE(p.`start_date`) > '2002-08-13'
    AND p.`end_date` IS NULL
ORDER BY
	e.`first_name` ASC, p.`name` ASC
LIMIT 5;

-- Task 8. Employee 24
SELECT
	e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`,
    IF(YEAR(p.`start_date`) >= 2005, NULL, p.`name`) AS `Project Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`employees_projects` AS ep
USING 
	(`employee_id`)
INNER JOIN
	`soft_uni`.`projects` AS p
USING 
	(`project_id`)
WHERE
	e.`employee_id` = 24
ORDER BY
	p.`name` ASC;

-- Task 9. Employee Manager
SELECT
	e.`employee_id` AS `Employee ID`,
    e.`first_name` AS `First Name`,
    e.`manager_id` AS `Manager ID`,
    e2.`first_name` AS `Manager Name` 
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`employees` AS e2
ON
	e.`manager_id` = e2.`employee_id`
WHERE
	e.`manager_id` = 3 OR e.`manager_id` = 7
ORDER BY
	e.`first_name` ASC;
    
-- Task 10. Employee Summary
SELECT
	e.`employee_id` AS `Employee ID`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `Employee Name`,
    CONCAT_WS(' ', e2.`first_name`, e2.`last_name`) AS `Manager Name`,
	d.`name` AS `Department Name`
FROM
	`soft_uni`.`employees` AS e
INNER JOIN
	`soft_uni`.`employees` AS e2
ON
	e.`manager_id` = e2.`employee_id`
INNER JOIN
	`soft_uni`.`departments` AS d
ON
	e.`department_id` = d.`department_id`
WHERE
	e.`manager_id` IS NOT NULL
ORDER BY
	e.`employee_id`
LIMIT 5;
    
-- Task 11. Min Average Salary
SELECT
	AVG(`salary`) AS `Min Average Salary`
FROM
	`soft_uni`.`employees`
GROUP BY
	`department_id`
ORDER BY
	`Min Average Salary` ASC
LIMIT 1;
    
-- First we need to create the geography database from geography database.sql file

-- Task 12. Highest Peaks in Bulgaria
USE `geography`;

SELECT
	c.`country_code` AS `Country Code`,
    m.`mountain_range` AS `Mountain Range`,
    p.`peak_name` AS `Peak Name`,
    p.`elevation` AS `Elevation`
FROM
	`geography`.`countries` AS c
INNER JOIN
	`geography`.`mountains_countries` AS mc
ON
	c.`country_code` = mc.`country_code`
INNER JOIN
	`geography`.`mountains` AS m
ON
	mc.`mountain_id` = m.`id`
INNER JOIN
	`geography`.`peaks` AS p
ON
	m.`id` = p.`mountain_id`
WHERE
	c.`country_name` = 'Bulgaria' AND p.`elevation` > 2835 
ORDER BY
	p.`elevation` DESC;
    
-- Task 13. Count Mountain Ranges
SELECT
	c.`country_code` AS `Country Code`,
    COUNT(m.`mountain_range`) AS `Mountain Range`
FROM
	`geography`.`countries` AS c
INNER JOIN
	`geography`.`mountains_countries` AS mc
ON
	c.`country_code` = mc.`country_code`
INNER JOIN
	`geography`.`mountains` AS m
ON
	mc.`mountain_id` = m.`id`
WHERE
	c.`country_name` IN ('United States', 'Russia', 'Bulgaria')
GROUP BY
	c.`country_code`
ORDER BY
	`Mountain Range` DESC;

-- Task 14. Countries with Rivers
SELECT
	c.`country_name` AS `Country Name`,
    r.`river_name` AS `River Name`
FROM
	`geography`.`countries` AS c
LEFT JOIN
    `geography`.`countries_rivers` AS cr
ON
	c.`country_code` = cr.`country_code`
LEFT JOIN
	`geography`.`rivers` AS r
ON
	cr.`river_id` = r.`id` 
INNER JOIN
	`geography`.`continents` AS con
ON
	c.`continent_code` = con.`continent_code`
WHERE
	con.`continent_name` = 'Africa'  
ORDER BY
	c.`country_name` ASC
LIMIT 5;
    
-- Task 16. Countries Without Any Mountains
SELECT
	COUNT(*) AS `Country Count`
FROM
	`geography`.`countries` AS c
WHERE
	c.`country_code` NOT IN
	(SELECT `country_code` FROM `geography`.`mountains_countries`);
    
-- Task 17. Highest Peak and Longest River by Country ***
SELECT
	c.`country_name` AS `Country Name`,
    MAX(p.`elevation`) AS `Highest Peak Elevation`,
	MAX(r.`length`) AS `Longest River Length`
FROM
	`geography`.`countries` as c
LEFT JOIN  
	`geography`.`mountains_countries` AS mc
ON 
	c.`country_code` = mc.`country_code`
LEFT JOIN
	`geography`.`mountains` AS m
ON
	mc.`mountain_id` = m.`id`
LEFT JOIN
	`geography`.`peaks` AS p
ON
	m.`id` = p.`mountain_id`
LEFT JOIN
	`geography`.`countries_rivers` AS cr
ON
	c.`country_code` = cr.`country_code`
LEFT JOIN
	`geography`.`rivers` AS r
ON
	cr.`river_id` = r.`id`
GROUP BY
	`Country Name`
ORDER BY
	`Highest Peak Elevation` DESC, 
    `Longest River Length` DESC,
    `Country Name` ASC
LIMIT 5;