CREATE TABLE IF NOT EXISTS `COUNTRIES` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(3) NOT NULL,
  `name` varchar(150) NOT NULL,
  `phonecode` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `COUNTRIES` (`id`, `code`, `name`, `phonecode`)
VALUES (1, 'AFG', 'Afghanistan', 93),
(2, 'IND', 'INDIA', 91),
(3, 'SIN', 'SINGAPORE', 65);
