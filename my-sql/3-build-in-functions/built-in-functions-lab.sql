-- First we need to create the booklibrary database from booklibrary.sql file

-- Task 1. Find Book Titles
SELECT
	`title`
FROM 
	`book_library`.`books`
WHERE 
	'The' = SUBSTR(`title`, 1, 3)
ORDER BY
	`id` ASC;
    
-- Task 2. Replace Titles
SELECT
    REPLACE(`title`, 'The', '***')
    AS `title`
FROM 
	`book_library`.`books`
WHERE
	'The' = SUBSTR(`title`, 1, 3)
ORDER BY 
	`id` ASC;
	
-- Task 3. Sum Cost of All Books
SELECT
	ROUND(AVG(`cost`), 2)
    AS `Average cost`
FROM 
	`book_library`.`books`;

-- Task 4. Days Lived
SELECT
	CONCAT_WS(' ', `first_name`, `last_name`)
    AS `Full name`,
	TIMESTAMPDIFF(DAY, `born`, `died`)
    AS `Days lived`    
FROM
	`book_library`.`authors`;

-- Task 5. Harry Potter Books
SELECT DISTINCT 
	`title`
FROM
	`book_library`.`books`
WHERE
	`title` LIKE 'Harry Potter%';