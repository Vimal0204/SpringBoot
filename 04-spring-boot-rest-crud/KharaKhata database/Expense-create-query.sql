CREATE DATABASE  IF NOT EXISTS `kharcha_khata`;
USE `kharcha_khata`;
-- 
--  table structure for the kharchakhata db
-- 
create table if not exists `Expenses`(
  `id` int NOT NULL AUTO_INCREMENT,
  `identify_id` varchar(45) DEFAULT NULL,
  `expense_name` varchar(45) DEFAULT NULL,
  `expense_amount` varchar(45) DEFAULT NULL,
  `expense_type` varchar(45) DEFAULT NULL,
  `expense_date` date default null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
INSERT INTO `Expenses` VALUES 
	(1,'cuEtVsbobBTb0M5CoFOtqhlKGW02','flutter Course','19.99','Travel','2023-12-25'),
	(2,'cuEtVsbobBTb0M5CoFOtqhlKGW02','Cinema','20.02','Leisure','2023-12-25');
	-- (3,'Avani','Gupta','avani@luv2code.com'),
	-- (4,'Yuri','Petrov','yuri@luv2code.com'),-- 
	-- (5,'Juan','Vega','juan@luv2code.com');-- 
