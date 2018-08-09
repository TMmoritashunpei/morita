--���e�[�u�����쐬����

--�mA�n
CREATE TABLE 
  quest
  (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    name_kana TEXT NOT NULL,
    sex TEXT NOT NULL,
    prefecture TEXT NOT NULL,
    age INTEGER DEFAULT 0,
    answer1 INTEGER NULL,
    answer2 TEXT NULL,
    answered TEXT NOT NULL
  )
;

--�m1�n
CREATE TABLE
  author
  (
    author_id TEXT PRIMARY KEY,
    name TEXT,
    name_kana TEXT,
    birth TEXT
  )
;

--�m2�n
CREATE TABLE
  order_desc
  (
    po_id INTEGER NOT NULL,
    p_id TEXT NOT NULL,
    quantity INTEGER,
    PRIMARY KEY (po_id, p_id)
  )
;

--�m3�n
CREATE TABLE
  sales
  (
    s_id TEXT NOT NULL,
    s_date TEXT NOT NULL,
    s_value INTEGER,
    PRIMARY KEY (s_id, s_date)
  )
;

--�m4�n
CREATE TABLE 
  books
  (
    isbn TEXT,
    title TEXT,
    price INTEGER,
    publish TEXT,
    publish_date TEXT,
    category_id TEXT,
    PRIMARY KEY (isbn)
  )
;

--�m5�n
CREATE TABLE
  rental
  (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id TEXT,
    isbn TEXT,
    rental_date TEXT,
    returned INTEGER DEFAULT 0
  )
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
  last_update TEXT
;


--�m1�n
ALTER TABLE
  books
ADD
  pages INTEGER DEFAULT 0 NOT NULL
;

ALTER TABLE
  books
ADD
  rating TEXT DEFAULT 'B' NOT NULL
;

--�m2�nALTER�ɂ���L�[�̒ǉ��͖��Ή�

--�m3�n
ALTER TABLE
  books
ADD
  sales INTEGER
;

--�m4�n
ALTER TABLE
  usr
ADD
  sex TEXT DEFAULT '�j'
;

ALTER TABLE
  usr
ADD
  job TEXT
;

--�m5�n
ALTER TABLE
  employee
ADD
  email TEXT
;


--�������e�[�u����̗�␧�������ύX����

--�mA�n���`�␧������̕ύX�͖��Ή�

--�m1�n���`�␧������̕ύX�͖��Ή�

--�m2�n���`�␧������̕ύX�͖��Ή�

--�m3�n���`�␧������̕ύX�͖��Ή�

--�m4�n���`�␧������̕ύX�͖��Ή�
