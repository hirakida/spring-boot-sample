CREATE TABLE `user` (
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `name`       VARCHAR(30) NOT NULL,
    `created_at` DATETIME    NOT NULL,
    `updated_at` DATETIME    NOT NULL
);
