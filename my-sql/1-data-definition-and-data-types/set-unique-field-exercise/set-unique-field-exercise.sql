ALTER TABLE `database`.`users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY(`id`),
ADD CONSTRAINT username UNIQUE(`username`);