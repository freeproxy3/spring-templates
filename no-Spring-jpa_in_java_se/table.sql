create database jpa_example;
use jpa_example;
drop table address;
CREATE TABLE address(
	id INT NOT NULL auto_increment, 
	street VARCHAR(50),
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;