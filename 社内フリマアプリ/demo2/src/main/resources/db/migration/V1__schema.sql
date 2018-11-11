CREATE TABLE IF NOT EXISTS items (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	item_name VARCHAR(30), price INT, condition VARCHAR(30), 
	payment VARCHAR(30), stock INT, comments text
);

CREATE TABLE IF NOT EXISTS users (
	username VARCHAR(30) NOT NULL PRIMARY KEY,
 	password VARCHAR(255), tel VARCHAR(20), mail VARCHAR(50), comments text
 );

CREATE TABLE IF NOT EXISTS categorys (
	id int(10)  auto_increment,
	category_name VARCHAR(20) ,
	PRIMARY KEY(id)
);

