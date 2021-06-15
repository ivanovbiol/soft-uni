-- Task 1. Employees with Salary Above 35000 
USE `soft_uni`;

DELIMITER $$$

CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
	SELECT 
		`first_name` AS `First Name`, 
        `last_name` AS `Last Name`
    FROM
		`soft_uni`.`employees`
	WHERE
		`salary` > 35000
	ORDER BY
		`first_name` ASC,
        `last_name` ASC,
        `employee_id` ASC;
END $$$

DELIMITER ;

CALL usp_get_employees_salary_above_35000;

DROP PROCEDURE usp_get_employees_salary_above_35000;

-- Task 2. Employees with Salary Above Number
DELIMITER $$$

CREATE PROCEDURE `usp_get_employees_salary_above` (`query_salary` DECIMAL(19, 4))
BEGIN
	SELECT
		`first_name` AS `First Name`,
        `last_name` AS `Last Name`
	FROM 
		`soft_uni`.`employees`
	WHERE
		`salary` >= `query_salary`
	ORDER BY
		`first_name` ASC,
        `last_name` ASC,
        `employee_id` ASC;
END $$$

DELIMITER ;

CALL usp_get_employees_salary_above(45000);

DROP PROCEDURE usp_get_employees_salary_above;

-- Task 3. Town Names Starting With
DELIMITER $$$

CREATE PROCEDURE `usp_get_towns_starting_with` (`prefix` VARCHAR(20))
BEGIN
	SELECT DISTINCT
		t.`name` AS `Town Name`
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
	WHERE
		LOWER(t.`name`) LIKE LOWER(CONCAT(prefix, '%'))
	ORDER BY
		t.`name` ASC;
END $$$

DELIMITER ;

CALL `usp_get_towns_starting_with`('b');

DROP PROCEDURE `usp_get_towns_starting_with`;

-- Task 4. Employees from Town
DELIMITER $$$

CREATE PROCEDURE `usp_get_employees_from_town` (`query_town_name` VARCHAR(50))
BEGIN
	SELECT
		e.`first_name` AS `First Name`,
        e.`last_name` AS `Last Name`
	FROM
		`soft_uni`.`employees` AS e
	INNER JOIN
		`soft_uni`.`addresses` AS a
	USING 
		(`address_id`)
	INNER JOIN
		`soft_uni`.`towns` AS t
	USING
		(`town_id`)
	WHERE
		t.`name` = `query_town_name`
	ORDER BY
		e.`first_name` ASC,
        e.`last_name` ASC,
        e.`employee_id` ASC;
END $$$

DELIMITER ;

CALL `usp_get_employees_from_town` ('Sofia');

DROP PROCEDURE `usp_get_employees_from_town`;

-- Task 5. Salary Level Function
DELIMITER $$$

CREATE FUNCTION `ufn_get_salary_level` (`query_salary` DECIMAL(19, 4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	
    DECLARE `Salary Level` VARCHAR(10);
    
    	IF (`query_salary` < 30000) THEN SET `Salary Level` := 'Low';
        ELSEIF (`query_salary` <= 50000) THEN SET `Salary Level` := 'Average';
        ELSE SET `Salary Level` := 'High';
        END IF;
            
RETURN `Salary Level`;

END $$$

DELIMITER ;


SELECT `ufn_get_salary_level` (13500.00) AS `Salary Level`; -- Low
SELECT `ufn_get_salary_level` (43300.00) AS `Salary Level`; -- Average
SELECT `ufn_get_salary_level` (125500.00) AS `Salary Level`; -- High

DROP FUNCTION `ufn_get_salary_level`;

-- Task 6. Employees by Salary Level
DELIMITER $$$

CREATE PROCEDURE `usp_get_employees_by_salary_level` (`query_level` VARCHAR(10))
BEGIN
	SELECT
		e.`first_name` AS `First Name`,
        e.`last_name` AS `Last Name`
	FROM
		`soft_uni`.`employees` AS e
	WHERE
		(SELECT `ufn_get_salary_level`(e.`salary`) = `query_level`) 
	ORDER BY
		e.`first_name` DESC,
        e.`last_name` DESC;
        
END $$$

DELIMITER ;

CALL `usp_get_employees_by_salary_level`('High');

DROP PROCEDURE `usp_get_employees_by_salary_level`;

-- Task 7. Define Function
DELIMITER $$$

CREATE FUNCTION `ufn_is_word_comprised` (`set_of_letters` VARCHAR(50), `word` VARCHAR(50))  
RETURNS INTEGER

DETERMINISTIC
BEGIN

	DECLARE `Return Result` INTEGER;
    
    IF `word` REGEXP(CONCAT('^[', set_of_letters, ']+$')) THEN SET `Return Result` := 1;
    ELSE SET `Return Result` := 0;
    END IF;
    
RETURN `Return Result`;

END $$$

DELIMITER ;

SELECT `ufn_is_word_comprised`('oistmiahf', 'Sofia') AS `Result`;
SELECT `ufn_is_word_comprised`('oistmiahf', 'halves') AS `Result`;
SELECT `ufn_is_word_comprised`('bobr', 'Rob') AS `Result`;

DROP FUNCTION `ufn_is_word_comprised`;

-- Task 8. Find Full Name
DELIMITER $$$

CREATE PROCEDURE `usp_get_holders_full_name` ()
BEGIN
	SELECT
		CONCAT(ah.`first_name`, ' ', ah.`last_name`) AS `Full Name`
	FROM
		`soft_uni`.`account_holders` AS ah
	ORDER BY
		`Full Name` ASC,
        ah.`id` ASC;
        
END $$$

DELIMITER ;

CALL `usp_get_holders_full_name`;

DROP PROCEDURE `usp_get_holders_full_name`;

-- Task 9. People with Balance Higher Than
DELIMITER $$$

CREATE PROCEDURE `usp_get_holders_with_balance_higher_than` (`query_number` INTEGER)
BEGIN
	
    SELECT
		ah.`first_name` AS `First Name`,
        ah.`last_name` AS `Last Name`
	FROM
		`soft_uni`.`account_holders` AS ah
	INNER JOIN
		`soft_uni`.`accounts` AS a
	ON
		ah.`id` = a.`account_holder_id`
	WHERE
		a.`balance` > `query_number`
	GROUP BY
        a.`account_holder_id`
	ORDER BY
		ah.`id` ASC;
		
END $$$

DELIMITER ;

CALL `usp_get_holders_with_balance_higher_than`(7000);

DROP PROCEDURE `usp_get_holders_with_balance_higher_than`;

-- Task 10. Future Value Function
DELIMITER $$$

CREATE FUNCTION `ufn_calculate_future_value`(`sum` DECIMAL(19, 4), `interest_rate` DOUBLE, `years` INTEGER)
RETURNS DECIMAL(19, 4)
DETERMINISTIC

BEGIN

	DECLARE `Result` DECIMAL(19, 4);

	SET `Result` =  `sum` * POWER((1 + `interest_rate`), `years`);

	RETURN `Result`;

END $$$

DELIMITER ;

SELECT `ufn_calculate_future_value`(1000, 0.5, 5) AS `Result`;

DROP FUNCTION `ufn_calculate_future_value`;

-- Task 11. Calculating Interest
DELIMITER $$$

CREATE PROCEDURE `usp_calculate_future_value_for_account`
(`account_id_param` INTEGER, `interest_rate_param` DECIMAL(19, 4))

BEGIN
	SELECT
		a.`id` AS `ID`,
        ah.`first_name` AS `First Name`,
        ah.`last_name` AS `Last Name`,
        a.`balance` AS `Current Balance`,
        (SELECT `ufn_calculate_future_value`(a.`balance`, `interest_rate_param`, 5)) 
        AS `Balance After 5 Years`
	FROM 
		`soft_uni`.`account_holders` AS ah
	INNER JOIN
		`soft_uni`.`accounts` AS a
	ON
		ah.`id` = a.`account_holder_id`
    WHERE
		a.`id` = `account_id_param`;
        
END $$$

DELIMITER ;

CALL `usp_calculate_future_value_for_account`(1, 0.1);

DROP PROCEDURE `usp_calculate_future_value_for_account`;




