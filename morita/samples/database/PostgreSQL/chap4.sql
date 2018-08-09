--●テーブルを作成する

--［A］
CREATE TABLE 
  quest
  (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    name_kana VARCHAR(255) NOT NULL,
    sex VARCHAR(5) NOT NULL,
    prefecture VARCHAR(10) NOT NULL,
    age INT DEFAULT 0,
    answer1 INT NULL,
    answer2 TEXT NULL,
    answered TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
  )
;

--［1］
CREATE TABLE
  author
  (
    author_id CHAR(5) PRIMARY KEY,
    name VARCHAR(30),
    name_kana VARCHAR(100),
    birth DATE
  )
;

--［2］
CREATE TABLE
  order_desc
  (
    po_id INT NOT NULL,
    p_id CHAR(10) NOT NULL,
    quantity INT,
    PRIMARY KEY (po_id, p_id)
  )
;

--［3］
CREATE TABLE
  sales
  (
    s_id CHAR(7) NOT NULL,
    s_date DATE NOT NULL,
    s_value INT,
    PRIMARY KEY (s_id, s_date)
  )
;

--［4］
CREATE TABLE 
  books
  (
    isbn CHAR(17),
    title VARCHAR(255),
    price INT,
    publish VARCHAR(30),
    publish_date DATE,
    category_id CHAR(5),
    PRIMARY KEY (isbn)
  )
;

--［5］
CREATE TABLE
  rental
  (
    id SERIAL PRIMARY KEY,
    user_id CHAR(7),
    isbn CHAR(13),
    rental_date DATE,
    returned SMALLINT DEFAULT 0
  )
;


--●新規にインデックスを作成する（CREATE INDEX命令）

--［A］
CREATE INDEX
  pub_date 
ON 
  books 
  (
    publish, 
    publish_date
  )
;

--［1］
CREATE INDEX 
  ind_rental
ON
  rental
  (
    rental_date
  )
;

--［2］
CREATE INDEX
  ind_order
ON
  order_main
  (
    order_date, delivery_date
  )
;

--［3］
CREATE INDEX
  ind_product
ON
  product
  (
    p_name
  )
;

--［4］
CREATE INDEX
  ind_usr
ON
  usr
  (
    prefecture,
    city,
    o_address
  )
;


--●既存テーブルに列や制約条件を追加する

--［A］
ALTER TABLE
  quest
ADD
  last_update TIMESTAMP
;


--［1］
ALTER TABLE
  books
ADD
  pages INT DEFAULT 0 NOT NULL,
ADD
  rating CHAR(1) DEFAULT 'B' NOT NULL
;

--［2］
CREATE TABLE
  sales
  (
    s_id CHAR(5) NOT NULL,
    s_date DATE NOT NULL,
    s_value INT DEFAULT 0
  )
;
ALTER TABLE
  sales
ADD
  PRIMARY KEY (s_id, s_date)
;

--［3］
ALTER TABLE
  books
ADD
  sales INT
;

--［4］
ALTER TABLE
  usr
ADD
  sex VARCHAR(5) DEFAULT '男'
;
ALTER TABLE
  usr
ADD
  job VARCHAR(30)
;

--［5］
ALTER TABLE
  employee
ADD
  email VARCHAR(255)
;


--●既存テーブル上の列や制約条件を変更する

--［A］
ALTER TABLE
  usr
ALTER COLUMN
  o_address 
TYPE
  VARCHAR(255)
;

--［1］
ALTER TABLE
  books
ALTER COLUMN
  publish
TYPE
  VARCHAR(100)
;

--［2］
ALTER TABLE
  employee
ALTER COLUMN
  l_name
TYPE
  VARCHAR(50),
ALTER COLUMN
  l_name
SET
  NOT NULL,
ALTER COLUMN
  f_name
TYPE
  VARCHAR(50),
ALTER COLUMN
  f_name
SET
  NOT NULL
;

--［3］
ALTER TABLE
  author
ALTER COLUMN
  name
SET DEFAULT
  ''
;

--［4］
ALTER TABLE
  access_log
ALTER COLUMN
  referer
TYPE
  VARCHAR(200)
;
