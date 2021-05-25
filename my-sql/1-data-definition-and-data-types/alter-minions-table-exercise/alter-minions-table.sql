ALTER TABLE `minions`.`towns`
CHANGE COLUMN `town_id` `id` INT NOT NULL AUTO_INCREMENT;

ALTER TABLE `minions`.`minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY `minions` (`town_id`)
REFERENCES `towns`(`id`); 
