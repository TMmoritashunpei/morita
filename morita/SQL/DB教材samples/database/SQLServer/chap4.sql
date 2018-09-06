--���e�[�u�����쐬����

--�mA�n
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

--�m1�n
CREATE TABLE
  author
  (
    author_id CHAR(5) PRIMARY KEY,
    name NVARCHAR(30),
    name_kana NVARCHAR(100),
    birth DATE
  )

--�m2�n
CREATE TABLE
  order_desc
  (
    po_id INT NOT NULL,
    p_id CHAR(10) NOT NULL,
    quantity INT,
    PRIMARY KEY (po_id, p_id)
  )

--�m3�n
CREATE TABLE
  sales
  (
    s_id CHAR(5) NOT NULL,
    s_date CHAR(7) NOT NULL,
    s_value INT,
    PRIMARY KEY (s_id, s_date)
  )

--�m4�n
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

--�m5�n
CREATE TABLE
  rental
  (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id CHAR(7),
    isbn CHAR(13),
    rental_date DATE,
    returned SMALLINT DEFAULT 0
  )


--���V�K�ɃC���f�b�N�X���쐬����iCREATE INDEX���߁j

--�mA�n
CREATE INDEX
  pub_date 
ON 
  books 
  (
    publish, 
    publish_date
  )

--�m1�n
CREATE INDEX 
  ind_rental
ON
  rental
  (
    rental_date
  )

--�m2�n
CREATE INDEX
  ind_order
ON
  order_main
  (
    order_date, delivery_date
  )

--�m3�n
CREATE INDEX
  ind_product
ON
  product
  (
    p_name
  )

--�m4�n
CREATE INDEX
  ind_usr
ON
  usr
  (
    prefecture,
    city,
    o_address
  )


--�������e�[�u���ɗ�␧�������ǉ�����

--�mA�n
ALTER TABLE
  quest
ADD
  last_update DATETIME2(7)


--�m1�n
ALTER TABLE
  books
ADD
  pages INT DEFAULT 0 NOT NULL,
  rating CHAR(1) DEFAULT 'B' NOT NULL

--�m2�n
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

--�m3�n
ALTER TABLE
  books
ADD
  sales INT

--�m4�n
ALTER TABLE
  usr
ADD
  sex NVARCHAR(5) DEFAULT '�j',
  job NVARCHAR(30)

--�m5�n
ALTER TABLE
  employee
ADD
  email VARCHAR(255)


--�������e�[�u����̗�␧�������ύX����

--�mA�n
ALTER TABLE
  usr
ALTER COLUMN
  o_address NVARCHAR(255) NULL

--�m1�n
ALTER TABLE
  books
ALTER COLUMN
  publish NVARCHAR(100) NULL

--�m2�n
ALTER TABLE
  employee
ALTER COLUMN
  l_name NVARCHAR(50) NOT NULL

ALTER TABLE
  employee
ALTER COLUMN
  f_name NVARCHAR(50) NOT NULL

--�m3�n
ALTER TABLE
  author
ALTER COLUMN
  name NVARCHAR(100)

--�m4�n
ALTER TABLE
  access_log
ALTER COLUMN
  referer VARCHAR(200) NULL

