ALTER TABLE `database`.`users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY(`id`, `username`);