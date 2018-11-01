CREATE TABLE items(
  id int(10)  auto_increment,
  name VARCHAR(20) ,
  user_id int(10) ,
  category_id int(10) ,
  picture_main text ,
  picture_sub1 text,
  picture_sub2 text,
  picture_sub3 text,
  display_flg TINYINT(1) ,
  payment VARCHAR(255) ,
  item_condition VARCHAR(255) ,
  price VARCHAR(10) ,
  comments text ,
  purchase_status TINYINT(1) ,
  date date ,
  PRIMARY KEY(id)
);

CREATE TABLE users(
  id int(10)  auto_increment,
  username VARCHAR(20) ,
  mail VARCHAR(255) ,
  password VARCHAR(255) ,
  login_check TINYINT(1) ,
  admin_flg TINYINT(1) ,
  employee_id int(10),
  item_id int(10),
  PRIMARY KEY(id)
);

CREATE TABLE categories(
  id int(10)  auto_increment,
  name VARCHAR(20) ,
  PRIMARY KEY(id)
);
