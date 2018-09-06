--●テーブルを作成する

--［A］
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

--［1］
CREATE TABLE
  author
  (
    author_id TEXT PRIMARY KEY,
    name TEXT,
    name_kana TEXT,
    birth TEXT
  )
;

--［2］
CREATE TABLE
  order_desc
  (
    po_id INTEGER NOT NULL,
    p_id TEXT NOT NULL,
    quantity INTEGER,
    PRIMARY KEY (po_id, p_id)
  )
;

--［3］
CREATE TABLE
  sales
  (
    s_id TEXT NOT NULL,
    s_date TEXT NOT NULL,
    s_value INTEGER,
    PRIMARY KEY (s_id, s_date)
  )
;

--［4］
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

--［5］
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
  last_update TEXT
;


--［1］
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

--［2］ALTERによる主キーの追加は未対応

--［3］
ALTER TABLE
  books
ADD
  sales INTEGER
;

--［4］
ALTER TABLE
  usr
ADD
  sex TEXT DEFAULT '男'
;

ALTER TABLE
  usr
ADD
  job TEXT
;

--［5］
ALTER TABLE
  employee
ADD
  email TEXT
;


--●既存テーブル上の列や制約条件を変更する

--［A］列定義や制約条件の変更は未対応

--［1］列定義や制約条件の変更は未対応

--［2］列定義や制約条件の変更は未対応

--［3］列定義や制約条件の変更は未対応

--［4］列定義や制約条件の変更は未対応
