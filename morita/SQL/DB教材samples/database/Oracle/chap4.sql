--���e�[�u�����쐬����

--�mA�n
CREATE TABLE 
  quest 
  (
    id INT,
    name NVARCHAR2(100) NOT NULL,
    name_kana NVARCHAR2(255) NOT NULL,
    sex NVARCHAR2(5) NOT NULL,
    prefecture NVARCHAR2(10) NOT NULL,
    age INT ,
    answer1 INT NULL,
    answer2 NVARCHAR2(2000) NULL,
    answered TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
  )
;

CREATE SEQUENCE
  quest_seq
;

--�m1�n
CREATE TABLE 
  author
  (
    author_id CHAR(5) PRIMARY KEY,
    name NVARCHAR2(30),
    name_kana NVARCHAR2(100),
    birth DATE
  )
;

--�m2�n
CREATE TABLE
  order_desc
  (
    po_id INT NOT NULL,
    p_id CHAR(10) NOT NULL,
    quantity INT,
    PRIMARY KEY (po_id, p_id)
  )
;

--�m3�n
CREATE TABLE
  sales
  (
    s_id CHAR(7) NOT NULL,
    s_date DATE NOT NULL,
    s_value INT,
    PRIMARY KEY (s_id, s_date)
  )
;

--�m4�n
CREATE TABLE 
  books
  (
    isbn CHAR(17),
    title NVARCHAR2(255),
    price INT,
    publish NVARCHAR2(30),
    publish_date DATE,
    category_id CHAR(5),
    PRIMARY KEY (isbn)
  )
;

--�m5�n
CREATE TABLE
  rental
  (
    id INT  PRIMARY KEY,
    user_id CHAR(7),
    isbn CHAR(13),
    rental_date DATE,
    returned SMALLINT DEFAULT 0
  )
;

CREATE SEQUENCE
  rental_seq
;

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
;

--�m1�n
CREATE INDEX 
  ind_rental
ON
  rental
  (
    rental_date
  )
;

--�m2�n
CREATE INDEX
  ind_order
ON
  order_main
  (
    order_date, delivery_date
  )
;

--�m3�n
CREATE INDEX
  ind_product
ON
  product
  (
    p_name
  )
;

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
;


--�������e�[�u���ɗ�␧�������ǉ�����

--�mA�n
ALTER TABLE
  quest
ADD
  last_update TIMESTAMP
;


--�m1�n
ALTER TABLE
  books
ADD
  (pages INT DEFAULT 0 NOT NULL)
ADD
  (rating CHAR(1) NOT NULL)
;

--�m2�n
CREATE TABLE
  sales
  (
    s_id CHAR(5) NOT NULL,
    s_date DATE NOT NULL,
    s_value INT
  )
;
ALTER TABLE
  sales
ADD
  PRIMARY KEY (s_id, s_date)
;

--�m3�n
ALTER TABLE
  books
ADD
  sales INT
;

--�m4�n
ALTER TABLE
  usr
ADD
  (sex NVARCHAR2(5))
ADD
  (job NVARCHAR2(30))
;

--�m5�n
ALTER TABLE
  employee
ADD
  (email VARCHAR2(255))
;


--�������e�[�u����̗�␧�������ύX����

--�mA�n
ALTER TABLE
  usr
MODIFY
  (o_address NVARCHAR2(255))
;

--�m1�n
ALTER TABLE
  books
MODIFY
  (publish NVARCHAR2(100))
;

--�m2�n
ALTER TABLE
  employee
MODIFY
  (l_name NVARCHAR2(50) NOT NULL,
  f_name NVARCHAR2(50) NOT NULL)
;

--�m3�n
ALTER TABLE
  author
MODIFY
  (name NVARCHAR2(100))
;

--�m4�n
ALTER TABLE
  access_log
MODIFY
  (referer VARCHAR2(200))
;
