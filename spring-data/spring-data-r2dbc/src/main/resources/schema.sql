CREATE TABLE IF NOT EXISTS `user` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `created_at` DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS `person` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `created_at` DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS `account` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `created_at` DATETIME NOT NULL
);
