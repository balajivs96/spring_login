CREATE TABLE IF NOT EXISTS `COUNTRIES` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(3) NOT NULL,
  `code` varchar(150) NOT NULL,
  `phonecode` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `STATE` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  `country_id` bigint(11) NOT NULL DEFAULT '1',
  
  PRIMARY KEY (`id`),
  constraint fk_states_country foreign key (country_id) references countries(id)
);

CREATE TABLE IF NOT EXISTS `CITIES` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(30) NOT NULL,
  `state_id` bigint(11) NULL,
  is_active bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
);
