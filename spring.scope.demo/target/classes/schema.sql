CREATE TABLE `user_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `address` (
  `id` int(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
  );