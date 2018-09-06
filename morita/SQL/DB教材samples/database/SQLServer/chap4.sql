--●テーブルを作成する

--［A］
CREATE TABLE 
  quest
  (
    id INT IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    name_kana NVARCHAR(255) NOT NULL,
    sex NVARCHAR(5) NOT NULL,
    prefecture NVARCHAR(10) NOT NULL,
    age FLOAT DEFAULT 0,
    answer1 FLOAT NULL,
    answer2 NVARCHAR(MAX) NULL,
    answered DATETIME2(7) NOT NULL,
    PRIMARY KEY (id)
  )

--［1］
CREATE TABLE
  author
  (
    author_id CHAR(5) PRIMARY KEY,
    name NVARCHAR(30),
    name_kana NVARCHAR(100),
    birth DATE
  )

--［2］
CREATE TABLE
  order_desc
  (
    po_id INT NOT NULL,
    p_id CHAR(10) NOT NULL,
    quantity INT,
    PRIMARY KEY (po_id, p_id)
  )

--［3］
CREATE TABLE
  sales
  (
    s_id CHAR(5) NOT NULL,
    s_date CHAR(7) NOT NULL,
    s_value INT,
    PRIMARY KEY (s_id, s_date)
  )

--［4］
CREATE TABLE 
  books
  (
    isbn CHAR(17),
    title NVARCHAR(255),
    price FLOAT,
    publish NVARCHAR(30),
    publish_date DATE,
    category_id CHAR(5),
    PRIMARY KEY (isbn)
  )

--［5］
CREATE TABLE
  rental
  (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id CHAR(7),
    isbn CHAR(13),
    rental_date DATE,
    returned SMALLINT DEFAULT 0
  )


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

--［1］
CREATE INDEX 
  ind_rental
ON
  rental
  (
    rental_date
  )

--［2］
CREATE INDEX
  ind_order
ON
  order_main
  (
    order_date, delivery_date
  )

--［3］
CREATE INDEX
  ind_product
ON
  product
  (
    p_name
  )

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


--●既存テーブルに列や制約条件を追加する

--［A］
ALTER TABLE
  quest
ADD
  last_update DATETIME2(7)


--［1］
ALTER TABLE
  books
ADD
  pages INT DEFAULT 0 NOT NULL,
  rating CHAR(1) DEFAULT 'B' NOT NULL

--［2］
CREATE TABLE
  sales
  (
    s_id CHAR(5) NOT NULL,
    s_date CHAR(7) NOT NULL,
    s_value INT DEFAULT 0
  )

ALTER TABLE
  sales
ADD
  PRIMARY KEY (s_id, s_date)

--［3］
ALTER TABLE
  books
ADD
  sales INT

--［4］
ALTER TABLE
  usr
ADD
  sex NVARCHAR(5) DEFAULT '男',
  job NVARCHAR(30)

--［5］
ALTER TABLE
  employee
ADD
  email VARCHAR(255)


--●既存テーブル上の列や制約条件を変更する

--［A］
ALTER TABLE
  usr
ALTER COLUMN
  o_address NVARCHAR(255) NULL

--［1］
ALTER TABLE
  books
ALTER COLUMN
  publish NVARCHAR(100) NULL

--［2］
ALTER TABLE
  employee
ALTER COLUMN
  l_name NVARCHAR(50) NOT NULL

ALTER TABLE
  employee
ALTER COLUMN
  f_name NVARCHAR(50) NOT NULL

--［3］
ALTER TABLE
  author
ALTER COLUMN
  name NVARCHAR(100)

--［4］
ALTER TABLE
  access_log
ALTER COLUMN
  referer VARCHAR(200) NULL

