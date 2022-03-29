CREATE TABLE IF NOT EXISTS `STATE` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `country_id` bigint(11) NOT NULL,
  
  PRIMARY KEY (`id`),
  constraint fk_states_country foreign key (country_id) references countries(id)
);

INSERT INTO `STATE` (`id`,`code`, `name`, `country_id`)
VALUES (1,'ANI', 'Andaman and Nicobar Islands', 2),
       (2,'AP', 'Andhra Pradesh', 2),
       (3,'ARP', 'Arunachal Pradesh', 2),
       (4,'AS', 'Assam', 2),
       (5,'BR', 'Bihar', 2),
       (6,'CD', 'Chandigarh', 2),
       (7,'CHH','Chhattisgarh', 2),
       (8,'DNH', 'Dadra and Nagar Haveli', 2),
       (9,'DD', 'Daman and Diu', 2),
       (10,'DHL', 'Delhi', 2),
       (11,'GOA', 'Goa', 2),
       (12,'GJ' 'Gujarat', 2),
       (13,'HAR', 'Haryana', 2),
       (31,'PDY', 'Pondicherry', 2),
       (32,'PNB', 'Punjab', 2),
       (33,'RAJ', 'Rajasthan', 2),
       (34,'SIK', 'Sikkim', 2),
       (35,'TN','Tamil Nadu', 2),
       (36,'TS', 'Telangana', 2);