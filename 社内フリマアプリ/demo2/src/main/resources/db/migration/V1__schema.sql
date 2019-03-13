CREATE TABLE IF NOT EXISTS items (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	item_name VARCHAR(30), price INT, conditions VARCHAR(30), 
	payment VARCHAR(30), stock INT, purchasecount INT, comments VARCHAR(255),
	user_id INT(10), category_id INT(10), filename MEDIUMBLOB,
	filename2 MEDIUMBLOB,filename3 MEDIUMBLOB,filename4 MEDIUMBLOB, exhibitcansellflg BOOLEAN,
	created_at timestamp not null default current_timestamp,
  	updated_at timestamp not null default current_timestamp on update current_timestamp
) character set 'utf8';

CREATE TABLE IF NOT EXISTS users (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
 	password VARCHAR(255), tel VARCHAR(20), mail VARCHAR(50), comments VARCHAR(255), slackname VARCHAR(30), filename MEDIUMBLOB,
 	created_at timestamp not null default current_timestamp,
  	updated_at timestamp not null default current_timestamp on update current_timestamp
 ) character set 'utf8';

CREATE TABLE IF NOT EXISTS categorys (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(20),
	created_at timestamp not null default current_timestamp,
  	updated_at timestamp not null default current_timestamp on update current_timestamp
) character set 'utf8';

CREATE TABLE IF NOT EXISTS purchases (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	purchase_name VARCHAR(20),
	stock INT,
	cansellflg BOOLEAN,
	purchaseflg BOOLEAN,
	filename VARCHAR(30),
	item_id INT(10),
	user_id INT(10),
	created_at timestamp not null default current_timestamp,
  	updated_at timestamp not null default current_timestamp on update current_timestamp
) character set 'utf8';


/*h2
CREATE TABLE IF NOT EXISTS items (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	item_name VARCHAR(30), price INT, conditions VARCHAR(30), 
	payment VARCHAR(30), stock INT, purchasecount INT, comments VARCHAR(255),
	user_id INT(10), category_id INT(10), filename VARCHAR(255),
	filename2 VARCHAR(255),filename3 VARCHAR(255),filename4 VARCHAR(255),exhibitcansellflg BOOLEAN,
	created_at timestamp not null default current_timestamp,
  	updated_at timestamp default current_timestamp
);

CREATE TABLE IF NOT EXISTS users (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30) NOT NULL,
 	password VARCHAR(255), tel VARCHAR(20), mail VARCHAR(50), comments VARCHAR(255), slackname VARCHAR(30), filename VARCHAR(255),
 	created_at timestamp not null default current_timestamp,
  	updated_at timestamp default current_timestamp
 );

CREATE TABLE IF NOT EXISTS categorys (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(20),
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS purchases (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	purchase_name VARCHAR(20),
	stock INT,
	cansellflg BOOLEAN,
	purchaseflg BOOLEAN,
	filename VARCHAR(30),
	item_id INT(10),
	user_id INT(10),
	created_at timestamp not null default current_timestamp,
  	updated_at timestamp default current_timestamp
); 
*/