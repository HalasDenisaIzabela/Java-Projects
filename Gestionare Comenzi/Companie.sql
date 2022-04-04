CREATE SCHEMA IF NOT EXISTS `tema3TPCompanie`;
USE `tema3TPCompanie`;

CREATE TABLE IF NOT EXISTS `Client` (`id` INT AUTO_INCREMENT, `nume` VARCHAR(64), `adresa` VARCHAR(64), `email` VARCHAR(32), `vrsta` INT, PRIMARY KEY(`id`));
CREATE TABLE IF NOT EXISTS `Produs` (`id` INT AUTO_INCREMENT, `nume` VARCHAR(64), `categorie` VARCHAR(64),  `pret` FLOAT, `cantitateProdus` INT, PRIMARY KEY(`id`));
CREATE TABLE IF NOT EXISTS `Comanda` (`id` INT AUTO_INCREMENT, `idClient` INT, `idProdus` INT, `cantitateProdus` INT, PRIMARY KEY(`id`));


INSERT INTO `Client` (`nume`, `adresa`, `email`, `varsta`) VALUES
	('Iza Denisa', 'Teilor Nr 1', 'denisaiza@yahoo.com', 20),
	('Lorena', 'Observator Nr 83', 'loremelisa@yahoo.com', 18),
	('Ana Maria', 'Calea Floresti Nr 143', 'anamaria@yahoo.com', 41),
	('Vasi', 'Motilor Nr 122', 'vasi@yahoo.com', 49);

INSERT INTO `Product` (`nume`, `categorie`, `pret`, `cantitateProdus`) VALUES
	('Ananas', 'fructe',  10, 40),
	('Mozzarela', 'lactate', 12, 50),
	('Corn cu ciocolata', 'panificatie', 2, 150),
	('Cartofi', 'legume', 1, 300);