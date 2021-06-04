-- First we need to create the gringotts database from the gringotts.sql file

-- Task 1. Records' Count
USE `gringotts`;

SELECT
	COUNT(`id`) AS `Number of Rows In The Table`
FROM
	`gringotts`.`wizzard_deposits`;

-- Task 2. Longest Magic Wand
SELECT
	MAX(`magic_wand_size`) AS `Longest Magic Wand`
FROM
	`gringotts`.`wizzard_deposits`;

-- Task 3. Longest Magic Wand Per Deposit Groups
SELECT
	`deposit_group` AS `Deposit Group`,
	MAX(`magic_wand_size`) AS `Longest Magic Wand`
FROM
	`gringotts`.`wizzard_deposits`
GROUP BY
	`Deposit Group`
ORDER BY
	`Longest Magic Wand` ASC,
    `Deposit Group` ASC;

-- Task 4. Smallest Deposit Group Per Magic Wand Size
SELECT 
    `deposit_group`
FROM
    `gringotts`.`wizzard_deposits`
GROUP BY 
	`deposit_group`
ORDER BY 
	AVG(`magic_wand_size`) ASC
LIMIT 1;

-- Task 5. Deposits Sum
SELECT
	`deposit_group` AS `Deposit Group`,
    SUM(`deposit_amount`) AS `Total Sum`
FROM
	`gringotts`.`wizzard_deposits`
GROUP BY
	`Deposit Group`
ORDER BY
	`Total Sum`;

-- Task 6. Deposits Sum for Ollivander Family
SELECT
	`deposit_group` AS `Deposit Group`,
    SUM(`deposit_amount`) AS `Total Sum`
FROM
	`gringotts`.`wizzard_deposits`
WHERE
	`magic_wand_creator` = 'Ollivander family'
GROUP BY
	`Deposit Group`
ORDER BY
	`Deposit Group` ASC;
	
-- Task 7. Deposits Filter
SELECT
	`deposit_group` AS `Deposit Group`,
    SUM(`deposit_amount`) AS `Total Sum` 
FROM
	`gringotts`.`wizzard_deposits`
WHERE
	`magic_wand_creator` = 'Ollivander family'
GROUP BY
	`Deposit Group`
HAVING 
	`Total Sum` < 150000
ORDER BY
	`Total Sum` DESC;

-- Task 8. Deposit Charge
SELECT
	`deposit_group` AS `Deposit Group`,
    `magic_wand_creator` AS `Magis Wand Creator`,
    MIN(`deposit_charge`) AS `Min Deposit Charge`
FROM
	`gringotts`.`wizzard_deposits`
GROUP BY
	`Deposit Group`, `Magis Wand Creator`
ORDER BY 
	`Magis Wand Creator`, `Deposit Group`;

-- Task 9. Age Groups
SELECT (
	CASE 
		WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN `age`BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
		ELSE '[61+]'
    END
) AS `Age Groups`,
	COUNT(*) AS `Count Of Wizards`
FROM	
	`gringotts`.`wizzard_deposits`
GROUP BY
	`Age Groups`
ORDER BY
	`Count Of Wizards` ASC;

-- Task 10. First Letter
SELECT DISTINCT
	SUBSTRING(`first_name`, 1, 1) AS `First Letter`
FROM
	`gringotts`.`wizzard_deposits`
WHERE
	`deposit_group` = 'Troll Chest'
GROUP BY
	`First Letter`
ORDER BY
	`First Letter` ASC;

-- Task 11. Average Interest 
SELECT
	`deposit_group` AS `Deposit Group`,
    `is_deposit_expired` AS `Is Deposit Expired`,
    AVG(`deposit_interest`) AS `Average Deposit Interest`
FROM
	`gringotts`.`wizzard_deposits`
WHERE
	`deposit_start_date` > '1985-01-01'
GROUP BY 
	`Deposit Group`, 
    `Is Deposit Expired`
ORDER BY
	`Deposit Group` DESC,
    `Is Deposit Expired` ASC;

-- First we need to create the soft_uni database from the soft-uni.sql file

-- Task 12. Employees Minimum Salaries
USE `soft_uni`;

SELECT
	`department_id` AS `Department ID`,
    MIN(`salary`) AS `Min Salary`
FROM
	`soft_uni`.`employees`
WHERE
	`department_id` IN (2,5,7) AND
    YEAR(`hire_date`) >= 2000
GROUP BY
	`Department ID`
ORDER BY
	`Department ID` ASC;

-- Task 13. Employees Average Salaries
CREATE TABLE `new_temp_table` AS ( 
	SELECT 
		*
	FROM 
		`soft_uni`.`employees`
	WHERE
		`salary` > 30000 AND 
        `manager_id` <> 42
);

UPDATE 
	`new_temp_table`
SET 
	`salary` = `salary` + 5000
WHERE
	`department_id` = 1;
    
SELECT
	`department_id` AS `Department ID`,
	AVG(`salary`) AS `Average Salary`
FROM
	`soft_uni`.`new_temp_table`
GROUP BY
 	`Department ID`
ORDER BY
	`Department ID`;

-- Task 14. Employees Maximum Salaries
SELECT
	`department_id` AS `Department ID`,
	MAX(`salary`) AS `Max Salary`
FROM
	`soft_uni`.`employees`
GROUP BY
 	`Department ID`
HAVING
	`Max Salary` NOT BETWEEN 30000 AND 70000
ORDER BY
	`Department ID`;

-- Task 15. Employees Count Salaries
SELECT
	COUNT(*) AS `Employees Without Manager`
FROM
	`soft_uni`.`employees`
WHERE
	`manager_id` IS NULL;

-- Task 16. 3rd Highest Salary ***
SELECT 
    outher_empl.`department_id` AS `Department ID`,
    (
		SELECT DISTINCT
            inner_empl.`salary`
        FROM
            `employees` AS inner_empl
        WHERE
            inner_empl.`department_id` = outher_empl.`department_id`
        ORDER BY 
        inner_empl.`salary` DESC
        LIMIT 1 OFFSET 2
	) AS `Third Highest Salary`
FROM
    `soft_uni`.`employees` AS outher_empl
GROUP BY 
	`Department ID`
HAVING
	`Third Highest Salary` IS NOT NULL
ORDER BY
	`Department ID` ASC;




-- Comment









