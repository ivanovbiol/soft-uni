CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB(900),
    `last_login_time` DATETIME,
    `is_detected` BOOLEAN
);

INSERT INTO `database`.`users`
VALUES
(1, 'some_username', 'some_password', NULL, '2021-05-25', true);

SELECT * FROM `database`.`users`;