CREATE TABLE IF NOT EXISTS items (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	item_name VARCHAR(30), price INT, condition VARCHAR(30), 
	payment VARCHAR(30), stock INT, comments text,
	user_id INT(10), category_id INT(10)
);

CREATE TABLE IF NOT EXISTS users (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
 	password VARCHAR(255), tel VARCHAR(20), mail VARCHAR(50), comments text
 );

CREATE TABLE IF NOT EXISTS categorys (
	id INT(10)  AUTO_INCREMENT,
	category_name VARCHAR(20) ,
	PRIMARY KEY(id)
);

