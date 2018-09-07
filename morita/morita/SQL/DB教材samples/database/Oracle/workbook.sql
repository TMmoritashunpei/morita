CREATE TABLE 
quest (
id INT,
name NVARCHAR2(100) NOT NULL,
name_kana NVARCHAR2(255) NOT NULL,
sex NVARCHAR2(5) NOT NULL,
prefecture NVARCHAR2(10) NOT NULL,
age INT DEFAULT 0 NULL,
answer1 INT NULL,
answer2 NVARCHAR2(2000) NULL,
answered TIMESTAMP NOT NULL,
PRIMARY KEY (id)
);

CREATE SEQUENCE quest_seq;

insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'山田太郎','ヤマダタロウ','男','東京都',30,3,'重宝しています。','2012-10-10  10:11:12');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'井上茉莉','イノウエマリ','女','神奈川県',25,2,'面白いです。','2012-10-16  7:15:14');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'上原遥','ウエハラハルカ','女','茨城県',26,1,'ちょっと難しいです。','2012-10-18  20:11:12');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'江本修子','エモトシュウコ','女','東京都',32,3,'次回作に期待しています。','2012-10-24  21:14:18');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'小野博美','オノヒロミ','女','神奈川県',40,2,'わかりやすいです。','2012-10-29  21:18:17');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'河合太郎','カワイタロウ','男','東京都',22,1,'絵が少ない。','2012-11-1  20:10:14');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'矢口一樹','ヤグチカズキ','男','茨城県',26,2,NULL,'2012-11-6  20:11:12');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'有木守','アリキマモル','男','千葉県',35,3,'買ってよかった。','2012-11-10  21:14:18');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'吉岡毅','ヨシオカツヨシ','男','埼玉県',18,3,NULL,'2012-11-21  14:18:19');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'和田駿','ワダシュン','男','東京都',41,1,NULL,'2012-11-26  21:18:17');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'清水一郎','シミズイチロウ','男','東京都',56,2,NULL,'2012-12-4  14:18:19');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'南幸一','ミナミコウイチ','男','神奈川県',36,2,'','2012-12-16  21:11:17');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'村井聡','ムライサトシ','男','茨城県',64,3,'文字が小さい。','2012-12-29  13:17:24');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'森本雄二','モリモトユウジ','男','東京都',19,1,NULL,'2013-1-5  21:22:12');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'西島泰治','ニシジマヤスハル','男','神奈川県',24,3,'読みやすいです。','2013-1-24  14:10:24');
insert into quest (id,name,name_kana,sex,prefecture,age,answer1,answer2,answered ) values (quest_seq.NEXTVAL,'根岸亜由美','ネギシアユミ','女','千葉県',34,3,'絵がかわいい。','2013-2-3  21:11:17');


CREATE TABLE 
usr (
user_id CHAR(7) NOT NULL,
l_name NVARCHAR2(20),
f_name NVARCHAR2(20),
l_name_kana NVARCHAR2(100),
f_name_kana NVARCHAR2(100),
prefecture NVARCHAR2(15),
city NVARCHAR2(20),
o_address NVARCHAR2(100),
tel VARCHAR2(20),
email VARCHAR2(255),
PRIMARY KEY (user_id)
);

INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200401','井上','一郎','イノウエ','イチロウ','千葉県','東千葉市北町','2-4-1','040-111-0001','inoue@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200402','上原','幸一','ウエハラ','コウイチ','神奈川県','神奈川市南町','1-5-2','040-222-0002','uehara@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200403','江本','聡','エモト','サトシ','茨城県','茨城市西町','2-1-12','040-333-0003','emoto@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200404','小野','雄二','オノ','ユウジ','東京都','東京市南町','3-2-6','040-111-0004','ono@examples.com');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200405','河合','泰治','カワイ','ヤスハル','神奈川県','神奈川市北町','4-2-12','040-222-0005','kawai@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200401','矢口','亜由美','ヤグチ','アユミ','千葉県','東千葉市南町','3-4-6','040-111-0011','yaguchi@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200402','有木','茉莉','アリキ','マリ','神奈川県','神奈川市北町','1-4-5','040-222-0012','yuki@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200403','吉岡','遥','ヨシオカ','ハルカ','茨城県','茨城市東町','7-2-1','040-333-0013','yoshi@examples.com');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200404','和田','修子','ワダ','シュウコ','東京都','東京市北町','6-1-11','040-111-0014','wada@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200405','松本','博美','マツモト','ヒロミ','神奈川県','神奈川市南町','3-4-21','040-222-0015','matsu@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200501','山田','太郎','ヤマダ','タロウ','東京都','東京市西町','0-0-0','040-111-0031','taro_yama@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200502','木下','一樹','キノシタ','カズキ','茨城県','茨城市東町','5-1-10','040-333-0006','kino@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200503','久保田','守','クボタ','マモル','千葉県','東千葉市南町','2-1-21','040-111-0007','kubota@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200504','児玉','毅','コダマ','ツヨシ','埼玉県','西埼玉市東町','3-4-11','040-444-0008','kodama@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200505','坂口','駿','サカグチ','シュン','栃木県','北栃木市西町','6-2-4','040-555-0009','saka@examples.com');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('A200506','井上','一郎','イノウエ','イチロウ','静岡県','南静岡市花町','4-2-1','040-666-0010','shimi@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200501','南','沙恵','ミナミ','サエ','茨城県','茨城市西町','3-3-2','040-333-0016','minami@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200502','村井','佐知子','ムライ','サチコ','千葉県','東千葉市北町','4-1-13','040-111-0017','murai@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200503','森本','絵里','モリモト','エリ','埼玉県','西埼玉市西町','2-1-4','040-444-0018','morimo@examples.com');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200504','西島','文子','ニシジマ','フミコ','栃木県','北栃木市東町','2-5-7','040-555-0019','nishi@wings.msn.to');
INSERT INTO usr (user_id,l_name,f_name,l_name_kana,f_name_kana,prefecture,city,o_address,tel,email) VALUES ('B200505','根岸','裕子','ネギシ','ユウコ','静岡県','南静岡市寺町','3-4-8','040-666-0020','negi@wings.msn.to');


CREATE TABLE 
books (
isbn CHAR(17) NOT NULL,
title NVARCHAR2(255),
price INT,
publish NVARCHAR2(30),
publish_date DATE,
category_id CHAR(5),
PRIMARY KEY (isbn)
);

INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-0','ハムスターの観察','900','山田出版','2010-11-1','Z9999');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-7981-0959-2','PEAR入門','3000','翔泳社','2012-9-8','P1111');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-7980-0945-8','PHP5サンプル集','3000','秀和システム','2012-11-1','P1111');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-8833-0000-1','SQLリファレンス','2500','日経BP','2013-2-15','S2222');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-4','フェレットの観察','1000','山田出版','2012-10-26','Z9999');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-7981-0722-0','XML辞典','3300','翔泳社','2011-9-16','X3333');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-7980-0522-3','JSPリファレンス','1800','秀和システム','2010-4-19','J4444');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-8833-0000-2','SQLプチブック','1600','日経BP','2010-11-30','S2222');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-8833-0000-3','XMLリファレンス','3200','日経BP','2012-11-24','X3333');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-9','SQL入門','5500','山田出版','2012-10-30','S2222');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-1','PHPドリル','5100','山田出版','2013-1-14','P1111');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-5','らくだの観察日記','1100','山田出版','2012-12-24','Z9999');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-6','あひるの観察日記','700','山田出版','2012-11-15','A9999');
INSERT INTO books (isbn,title,price,publish,publish_date,category_id) VALUES ('4-0010-0000-7','かえるの観察日記','800','山田出版','2013-1-15','H9999');


CREATE TABLE 
author_books (
isbn CHAR(13) NOT NULL,
author_id CHAR(5) NOT NULL,
PRIMARY KEY (isbn,author_id)
);

INSERT INTO author_books (isbn,author_id) VALUES ('4-0010-0000-0','Y0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-7981-0959-2','Y0002');
INSERT INTO author_books (isbn,author_id) VALUES ('4-7980-0945-8','Y0002');
INSERT INTO author_books (isbn,author_id) VALUES ('4-8833-0000-1','S0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-0010-0000-4','Y0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-7981-0722-0','Y0002');
INSERT INTO author_books (isbn,author_id) VALUES ('4-7980-0522-3','Y0002');
INSERT INTO author_books (isbn,author_id) VALUES ('4-8833-0000-2','K0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-8833-0000-3','T0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-0010-0000-9','M0001');
INSERT INTO author_books (isbn,author_id) VALUES ('4-0010-0000-1','A0001');


CREATE TABLE 
author (
author_id CHAR(5) NOT NULL,
name NVARCHAR2(30),
name_kana NVARCHAR2(100),
birth DATE,
PRIMARY KEY (author_id)
);

INSERT INTO author (author_id,name,name_kana,birth) VALUES ('Y0001','山田愛子','ヤマダアイコ','1970-04-06');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('S0001','佐藤一郎','サトウイチロウ','1973-05-06');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('T0001','田中太郎','タナカタロウ','1975-11-01');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('M0001','守口靖男','モリグチヤスオ','1980-12-16');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('Y0002','山田祥寛','ヤマダヨシヒロ','1960-12-04');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('A0001','有吉晴美','アリヨシハルミ','1985-02-15');
INSERT INTO author (author_id,name,name_kana,birth) VALUES ('K0001','川中智樹','カワナカトモキ','1986-03-12');


CREATE TABLE 
category (
category_id CHAR(5) NOT NULL,
category_name NVARCHAR2(50),
PRIMARY KEY (category_id)
);

INSERT INTO category (category_id,category_name) VALUES ('Z9999','未分類');
INSERT INTO category (category_id,category_name) VALUES ('P1111','PHP');
INSERT INTO category (category_id,category_name) VALUES ('S2222','SQL');
INSERT INTO category (category_id,category_name) VALUES ('X3333','XML');
INSERT INTO category (category_id,category_name) VALUES ('J4444','Java');


CREATE TABLE 
rental (
id INT NOT NULL,
user_id CHAR(7),
isbn CHAR(13),
rental_date DATE,
returned SMALLINT DEFAULT 0,
PRIMARY KEY (id)
);

CREATE SEQUENCE rental_seq;

INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200501','4-0010-0000-0','2011-12-01','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200403','4-8833-0000-2','2010-12-03','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200405','4-8833-0000-2','2011-03-20','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200403','4-8833-0000-2','2011-04-16','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200405','4-0010-0000-0','2012-01-16','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200502','4-8833-0000-2','2011-07-22','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200505','4-8833-0000-2','2011-08-23','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200501','4-8833-0000-2','2011-11-10','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200503','4-8833-0000-2','2012-01-20','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200504','4-0010-0000-0','2012-03-20','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200401','4-8833-0000-2','2012-02-11','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200402','4-8833-0000-2','2012-02-22','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200404','4-8833-0000-2','2012-03-19','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200405','4-0010-0000-0','2012-06-14','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200402','4-8833-0000-2','2012-08-27','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200404','4-8833-0000-2','2012-12-10','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200502','4-7980-0522-3','2011-10-25','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200506','4-7981-0722-0','2012-03-26','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200501','4-0010-0000-0','2012-09-15','1');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200503','4-8833-0000-1','2013-03-16','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200504','4-7980-0945-8','2013-01-14','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200505','4-7981-0959-2','2013-01-12','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'A200405','4-8833-0000-3','2012-12-22','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200403','4-0010-0000-9','2012-12-27','0');
INSERT INTO rental (id,user_id,isbn,rental_date,returned) VALUES (rental_seq.NEXTVAL,'B200405','4-0010-0000-1','2013-03-10','0');


CREATE TABLE 
employee (
s_id CHAR(7) NOT NULL,
l_name NVARCHAR2(20),
f_name NVARCHAR2(20),
l_name_kana NVARCHAR2(100),
f_name_kana NVARCHAR2(100),
sex SMALLINT,
class NVARCHAR2(20),
depart_id CHAR(3),
b_id CHAR(7),
last_update DATE,
retired SMALLINT,
PRIMARY KEY (s_id)
);

INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('AI00001','相沢','聡','アイザワ','サトシ',1,'部長','S02','','2012-02-24',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('DA00001','大門','一郎','ダイモン','イチロウ',1,'担当','J01','AI00001','2011-08-10',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('FU00001','藤井','雄太','フジイ','ユウタ',1,'主任','E01','SE00001','2011-04-10',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('FU00002','藤岡','幸太郎','フジオカ','コウタロウ',1,'担当','E01','FU00001','2011-06-12',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('HA0001','速水','和幸','ハヤミ','カズユキ',1,'部長','E01','','2007-02-03',1);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('HA0002','葉山','俊輔','ハヤマ','シュンスケ',1,'アシスタント','E01','FU00002','2012-12-11',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('KA00001','川口','裕子','カワグチ','ユウコ',2,'アシスタント','S01','KI0001','2012-12-28',1);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('KA00002','加藤','昭雄','カトウ','アキオ',1,'アシスタント','S01','KI0001','2011-11-11',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('KA00003','神田','佐知子','カンダ','サチコ',1,'アシスタント','J01','KA00003','2012-01-28',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('KI00001','木村','一郎','キムラ','イチロウ',1,'担当','S01','TA00001','2011-07-12',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('NA00001','中澤','康代','ナカザワ','ヤスヨ',2,'アシスタント','S02','TO00002','2012-04-17',1);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('NO00001','野上','利江','ノガミ','リエ',2,'アシスタント','S02','TO00002','2012-06-30',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('SA00001','佐藤','智子','サトウ','トモコ',2,'部長','S01','','2010-02-01',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('SE00001','妹尾','春樹','セノオ','ハルキ',1,'課長','E01','TE00001','2010-12-10',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('SI00001','清水','春子','シミズ','ハルコ',2,'主任','J01','SI00001','2011-12-11',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TA00001','田中','真由子','タナカ','マユコ',2,'主任','S01','YA00001','2011-05-26',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TA00002','田辺','正一','タナベ','ショウイチ',1,'アシスタント','E01','HA0002','2012-12-19',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TE00001','寺岡','陽一','テラオカ','ヨウイチ',1,'部長','E01','HA0001','2009-12-11',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TI00001','近田','晃子','チカダ','アキコ',2,'課長','S02','AI00001','2012-03-01',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TO00001','遠山','真一','トオヤマ','シンイチ',1,'課長','J01','UE00001','2010-12-16',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TO00002','戸川','よしみ','トガワ','ヨシミ',2,'担当','S02','TU00001','2012-04-01',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('TU00001','津村','知美','ツムラ','カズミ',2,'主任','S02','TI00001','2012-03-16',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('UE00001','上田','一也','ウエダ','カズヤ',1,'部長','J01','','2011-11-12',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('YA00001','山田','奈美','ヤマダ','ナミ',2,'課長','S01','SA00001','2012-10-15',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('NI00001','西','雄一','ニシ','ユウイチ',1,'アシスタント','B01','','2013-01-10',0);
INSERT INTO employee (s_id,l_name,f_name,l_name_kana,f_name_kana,sex,class,depart_id,b_id,last_update,retired) VALUES ('NI00002','新渡戸','康治','ニトベ','コウジ',1,'アシスタント','B01','','2013-01-15',0);


CREATE TABLE 
depart (
depart_id CHAR(3) NOT NULL,
depart_name NVARCHAR2(20),
PRIMARY KEY (depart_id)
);

INSERT INTO depart (depart_id,depart_name) VALUES ('S01','経営企画部');
INSERT INTO depart (depart_id,depart_name) VALUES ('E01','第一営業部');
INSERT INTO depart (depart_id,depart_name) VALUES ('E02','第二営業部');
INSERT INTO depart (depart_id,depart_name) VALUES ('J01','人事部');
INSERT INTO depart (depart_id,depart_name) VALUES ('S02','総務部');


CREATE TABLE 
time_card (
s_id CHAR(7) NOT NULL,
r_date DATE NOT NULL,
work_time INT,
PRIMARY KEY (s_id,r_date)
);

INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-01',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-02',11);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-05',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-13',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-14',4);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-19',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-20',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-23',11);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-26',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-12-28',6);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-05',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-06',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-13',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-19',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-26',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-12-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-05',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-06',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-08',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-13',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-15',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-19',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-26',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-12-28',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-05',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-06',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-08',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-12',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-13',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-15',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-19',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-20',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-26',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-27',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-12-28',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-03',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-08',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-15',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-17',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-24',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-28',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-01',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-03',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-04',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-11',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-15',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-22',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-24',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-29',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KI00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-01',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-02',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-11',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-18',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-22',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-25',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-29',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00001','2012-11-30',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-07',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-09',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-16',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-18',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-23',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-25',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-28',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00002','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-03',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-14',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-16',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-24',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-01',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-03',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-10',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-17',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-21',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-22',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-29',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('FU00002','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-01',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-08',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-10',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-15',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-17',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-18',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-25',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-29',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('HA0002','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-04',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-08',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-11',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-15',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-16',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-23',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-25',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TA00002','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-02',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-04',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-11',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('SI00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-01',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-03',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-04',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-11',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-15',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-22',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-24',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-29',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('DA00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-01',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-02',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-09',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-11',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-18',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-22',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-25',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-29',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('KA00003','2012-11-30',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-07',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-09',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-16',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-18',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-23',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-25',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-28',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TU00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-01',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-03',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-07',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-10',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-14',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-16',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-17',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-21',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-23',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-24',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-29',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('TO00002','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-01',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-03',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-08',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-10',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-14',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-15',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-17',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-18',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-21',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-22',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-25',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-29',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NA00001','2012-11-30',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-01',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-02',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-03',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-04',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-07',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-08',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-09',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-10',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-11',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-14',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-15',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-16',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-17',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-18',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-21',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-22',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-23',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-24',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-25',9);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-28',8);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-29',10);
INSERT INTO time_card (s_id,r_date,work_time) VALUES ('NO00001','2012-11-30',8);

CREATE TABLE 
shop (
s_id CHAR(5) NOT NULL,
s_name NVARCHAR2(30),
PRIMARY KEY (s_id)
);

INSERT INTO shop (s_id,s_name) VALUES ('M0001','三吉町店');
INSERT INTO shop (s_id,s_name) VALUES ('M0002','三吉町南店');
INSERT INTO shop (s_id,s_name) VALUES ('H0001','東桜町店');
INSERT INTO shop (s_id,s_name) VALUES ('K0001','北花町駅前店');
INSERT INTO shop (s_id,s_name) VALUES ('K0002','北花町東店');


CREATE TABLE 
sales (
s_id CHAR(5) NOT NULL,
s_date char(7) NOT NULL,
s_value INT,
PRIMARY KEY (s_id,s_date)
);

INSERT INTO sales (s_id,s_date,s_value) VALUES ('M0001','2012-12',11145);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('H0001','2012-12',9861);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('N0001','2012-12',11023);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('K0001','2012-12',11234);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('K0002','2012-12',10456);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('M0001','2012-11',10784);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('M0002','2012-11',12032);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('H0001','2012-11',9975);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('N0001','2012-11',9965);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('K0001','2012-11',10142);
INSERT INTO sales (s_id,s_date,s_value) VALUES ('K0002','2012-11',10124);


CREATE TABLE 
order_main (
po_id INT NOT NULL,
user_id CHAR(7),
order_date DATE,
delivery_date DATE,
PRIMARY KEY (po_id)
);

CREATE SEQUENCE order_main_seq;

INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200405','2011-02-01','2011-02-07');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200401','2011-03-02','2011-03-05');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200402','2011-03-15','2011-03-18');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200403','2011-04-15','2011-04-20');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200404','2011-06-19','2011-06-30');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200501','2011-08-05','2011-08-15');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200501','2011-08-05','2011-08-15');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200502','2011-08-24','2011-09-01');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200503','2011-10-25','2011-11-01');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200405','2011-12-04','2011-12-13');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200501','2012-01-15','2012-01-19');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'A200506','2012-02-14','2012-02-24');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200501','2012-03-02','2012-03-05');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200502','2012-04-05','2012-04-16');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200503','2012-05-21','2012-05-30');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200504','2012-06-04','2012-06-12');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200501','2012-12-01','2012-12-08');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200502','2012-12-14','2012-12-18');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200503','2012-12-22','');
INSERT INTO order_main (po_id,user_id,order_date,delivery_date) VALUES (order_main_seq.NEXTVAL,'B200504','2012-12-25','');


CREATE TABLE 
order_desc (
po_id INT NOT NULL,
p_id CHAR(10) NOT NULL,
quantity INT,
PRIMARY KEY (po_id,p_id)
);

INSERT INTO order_desc (po_id,p_id,quantity) VALUES (1,'PB00000001',200);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (2,'PB00000002',300);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (3,'DE00000001',20);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (4,'TO00000001',10);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (5,'TO00000002',10);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (6,'TU00000001',2);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (7,'IS00000001',3);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (8,'PB00000001',100);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (9,'PB00000002',150);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (10,'DE00000001',10);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (11,'TO00000001',5);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (12,'TO00000002',5);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (13,'PB00000001',1);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (14,'PB00000002',50);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (15,'DE00000001',50);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (16,'TO00000001',5);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (17,'TO00000002',5);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (18,'PB00000001',100);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (19,'PB00000002',100);
INSERT INTO order_desc (po_id,p_id,quantity) VALUES (20,'DE00000001',10);


CREATE TABLE 
product (
p_id CHAR(10) NOT NULL,
p_name NVARCHAR2(255),
price INT,
PRIMARY KEY (p_id)
);

INSERT INTO product (p_id,p_name,price) VALUES ('PB00000001','黒ボールペン',100);
INSERT INTO product (p_id,p_name,price) VALUES ('PB00000002','赤ボールペン',100);
INSERT INTO product (p_id,p_name,price) VALUES ('DE00000001','電卓',600);
INSERT INTO product (p_id,p_name,price) VALUES ('TO00000001','トナー黒',1000);
INSERT INTO product (p_id,p_name,price) VALUES ('TO00000002','トナー赤',1000);
INSERT INTO product (p_id,p_name,price) VALUES ('TU00000001','机',15000);
INSERT INTO product (p_id,p_name,price) VALUES ('IS00000001','椅子',10000);
INSERT INTO product (p_id,p_name,price) VALUES ('MA00000001','マウスパッド',1500);


CREATE TABLE 
menu (
page_id CHAR(5) NOT NULL,
title NVARCHAR2(100),
parent CHAR(5),
PRIMARY KEY (page_id)
);

INSERT INTO menu (page_id,title,parent) VALUES ('A0001','ホーム','');
INSERT INTO menu (page_id,title,parent) VALUES ('B0001','WINGSについて','A0001');
INSERT INTO menu (page_id,title,parent) VALUES ('B0002','WINGSの歴史','B0001');
INSERT INTO menu (page_id,title,parent) VALUES ('B0003','WINGSメンバー紹介','B0001');
INSERT INTO menu (page_id,title,parent) VALUES ('B0004','WINGSメンバ募集','B0001');
INSERT INTO menu (page_id,title,parent) VALUES ('C0001','技術記事オンライン公開','A0001');
INSERT INTO menu (page_id,title,parent) VALUES ('C0002','最新インターネット記事','C0001');
INSERT INTO menu (page_id,title,parent) VALUES ('C0003','PHP関連記事','C0001');
INSERT INTO menu (page_id,title,parent) VALUES ('C0004','Java関連記事','C0001');
INSERT INTO menu (page_id,title,parent) VALUES ('C0005','ASP.NET関連記事','C0001');
INSERT INTO menu (page_id,title,parent) VALUES ('D0001','新刊案内','A0001');
INSERT INTO menu (page_id,title,parent) VALUES ('D0002','PHP関連新刊','D0001');
INSERT INTO menu (page_id,title,parent) VALUES ('D0003','Java関連新刊','D0001');
INSERT INTO menu (page_id,title,parent) VALUES ('D0004','ASP.NET関連新刊','D0001');


CREATE TABLE 
access_log (
log_id INT NOT NULL,
page_id CHAR(5),
referer VARCHAR2(255),
ip_address CHAR(15),
access_date TIMESTAMP,
PRIMARY KEY (log_id)
);

INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (1,'A0001','http://wings.msn.to/hamu/','192.168.0.253','2012-02-01 10:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (2,'A0001','http://wings.msn.to/hamu/','192.168.1.223','2012-02-12 07:15:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (3,'B0001','http://wings.msn.to/hamu/','192.168.21.18','2012-02-19 20:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (4,'A0001','http://wings.msn.to/hamu/','192.168.115.25','2012-03-01 21:14:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (5,'A0001','http://wings.msn.to/hamu/','192.168.29.208','2012-03-11 21:18:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (6,'A0001','http://wings.msn.to/hamu/','192.168.3.254','2012-03-19 20:10:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (7,'A0001','http://wings.msn.to/neko/','192.168.42.217','2012-03-19 20:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (8,'B0001','http://wings.msn.to/inu/','192.168.81.112','2012-04-01 21:14:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (9,'B0001','http://wings.msn.to/hamu/','192.168.165.27','2012-04-10 14:18:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (10,'B0002','http://wings.msn.to/neko/','192.168.29.207','2012-04-11 21:18:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (11,'B0003','http://wings.msn.to/neko/','192.168.4.257','2012-05-10 14:18:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (12,'A0001','http://wings.msn.to/hamu/','192.168.142.207','2012-05-21 21:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (13,'A0001','http://wings.msn.to/hamu/','192.168.41.102','2012-05-30 13:17:24');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (14,'D0001','http://wings.msn.to/hamu/','192.168.195.123','2012-06-01 21:22:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (15,'D0001','http://wings.msn.to/hamu/','192.168.209.247','2012-06-04 14:10:24');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (16,'B0004','http://wings.msn.to/saru/','192.168.16.209','2012-06-21 21:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (17,'A0001','http://wings.msn.to/hamu/','192.168.206.143','2012-06-30 01:11:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (18,'C0001','http://wings.msn.to/inu/','192.168.211.110','2012-06-30 13:17:24');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (19,'A0001','http://wings.msn.to/hamu/','192.168.165.20','2012-07-01 22:14:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (20,'A0001','http://wings.msn.to/hamu/','192.168.219.48','2012-07-06 08:14:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (21,'A0001','http://wings.msn.to/hamu/','192.168.31.204','2012-07-09 20:11:02');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (22,'A0001','http://wings.msn.to/hamu/','192.168.32.237','2012-07-11 23:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (23,'A0001','http://wings.msn.to/hamu/','192.168.64.92','2012-07-13 15:17:25');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (24,'D0001','http://wings.msn.to/hamu/','192.168.15.87','2012-07-18 09:11:46');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (25,'D0001','http://wings.msn.to/hamu/','192.168.69.177','2012-07-24 04:11:38');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (26,'C0002','http://wings.msn.to/neko/','192.168.14.215','2012-07-30 01:11:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (27,'A0001','http://wings.msn.to/hamu/','192.168.12.27','2012-08-01 21:28:39');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (28,'C0003','http://wings.msn.to/saru/','192.168.31.12','2012-08-01 22:14:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (29,'A0001','http://wings.msn.to/hamu/','192.168.15.126','2012-08-04 15:13:34');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (30,'A0001','http://wings.msn.to/hamu/','192.168.29.217','2012-08-07 23:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (31,'B0001','http://wings.msn.to/hamu/','192.168.1.253','2012-08-09 20:24:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (32,'A0001','http://wings.msn.to/hamu/','192.168.2.223','2012-08-13 23:10:57');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (33,'A0001','http://wings.msn.to/hamu/','192.168.22.18','2012-08-16 15:18:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (34,'C0004','http://wings.msn.to/neko/','192.168.116.25','2012-08-18 09:11:46');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (35,'A0001','http://wings.msn.to/hamu/','192.168.30.208','2012-08-21 20:17:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (36,'C0005','http://wings.msn.to/tori/','192.168.4.254','2012-08-24 04:11:38');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (37,'A0001','http://wings.msn.to/hamu/','192.168.43.217','2012-08-24 23:14:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (38,'A0001','http://wings.msn.to/hamu/','192.168.82.112','2012-08-25 11:24:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (39,'A0001','http://wings.msn.to/hamu/','192.168.166.27','2012-08-26 21:25:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (40,'A0001','http://wings.msn.to/hamu/','192.168.30.207','2012-08-27 14:13:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (41,'A0001','http://wings.msn.to/hamu/','192.168.152.200','2012-08-27 23:11:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (42,'D0004','http://wings.msn.to/neko/','192.168.152.207','2012-08-27 23:11:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (43,'A0001','http://wings.msn.to/hamu/','192.168.42.102','2012-08-29 07:17:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (44,'A0001','http://wings.msn.to/hamu/','192.168.185.123','2012-08-30 23:17:47');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (45,'D0001','http://wings.msn.to/neko/','192.168.210.247','2012-09-01 21:28:39');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (46,'A0001','http://wings.msn.to/hamu/','192.168.17.209','2012-09-01 22:25:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (47,'A0001','http://wings.msn.to/hamu/','192.168.207.143','2012-09-01 23:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (48,'B0001','http://wings.msn.to/hamu/','192.168.212.110','2012-09-02 07:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (49,'A0001','http://wings.msn.to/hamu/','192.168.166.20','2012-09-03 04:10:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (50,'D0002','http://wings.msn.to/inu/','192.168.220.48','2012-09-04 15:13:34');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (51,'A0001','http://wings.msn.to/hamu/','192.168.32.204','2012-09-05 11:16:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (52,'A0001','http://wings.msn.to/hamu/','192.168.31.237','2012-09-05 20:18:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (53,'A0001','http://wings.msn.to/hamu/','192.168.65.92','2012-09-06 21:18:11');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (54,'D0003','http://wings.msn.to/tori/','192.168.19.87','2012-09-07 23:11:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (55,'A0001','http://wings.msn.to/hamu/','192.168.70.177','2012-09-07 23:11:54');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (56,'A0001','http://wings.msn.to/hamu/','192.168.15.215','2012-09-09 21:14:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (57,'A0001','http://wings.msn.to/hamu/','192.168.13.27','2012-09-10 21:18:50');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (58,'D0001','http://wings.msn.to/hamu/','192.168.32.12','2012-09-15 23:17:48');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (59,'A0001','http://wings.msn.to/hamu/','192.168.16.126','2012-09-16 14:12:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (60,'A0001','http://wings.msn.to/hamu/','192.168.30.217','2012-09-16 23:10:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (61,'D0001','http://wings.msn.to/hamu/','192.168.0.242','2012-09-19 11:13:00');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (62,'A0001','http://wings.msn.to/hamu/','192.168.1.212','2012-09-21 14:18:41');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (63,'A0001','http://wings.msn.to/hamu/','192.168.21.07','2012-09-22 16:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (64,'A0001','http://wings.msn.to/hamu/','192.168.115.14','2012-09-23 20:19:11');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (65,'D0001','http://wings.msn.to/hamu/','192.168.29.197','2012-09-25 20:11:52');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (66,'D0001','http://wings.msn.to/hamu/','192.168.3.243','2012-09-27 05:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (67,'A0001','http://wings.msn.to/hamu/','192.168.42.206','2012-09-29 00:12:16');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (68,'A0001','http://wings.msn.to/kame/','192.168.81.101','2012-09-29 07:17:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (69,'B0001','http://wings.msn.to/saru/','192.168.16516','2012-09-30 23:17:47');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (70,'B0002','http://wings.msn.to/neko/','192.168.29.215','2012-10-01 22:25:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (71,'A0001','http://wings.msn.to/hamu/','192.168.4.246','2012-10-03 10:11:16');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (72,'A0001','http://wings.msn.to/hamu/','192.168.142.196','2012-10-09 20:24:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (73,'A0001','http://wings.msn.to/hamu/','192.168.41.93','2012-10-13 23:10:57');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (74,'C0001','http://wings.msn.to/hamu/','192.168.195.112','2012-10-16 15:18:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (75,'A0001','http://wings.msn.to/hamu/','192.168.209.236','2012-10-21 20:17:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (76,'A0001','http://wings.msn.to/hamu/','192.168.16.198','2012-10-24 23:14:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (77,'C0001','http://wings.msn.to/hamu/','192.168.206.132','2012-10-25 11:24:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (78,'A0001','http://wings.msn.to/hamu/','192.168.211.109','2012-10-26 21:25:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (79,'A0001','http://wings.msn.to/hamu/','192.168.165.19','2012-10-27 14:13:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (80,'D0001','http://wings.msn.to/hamu/','192.168.219.37','2012-10-27 23:11:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (81,'D0001','http://wings.msn.to/hamu/','192.168.31.193','2012-10-29 07:17:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (82,'A0001','http://wings.msn.to/hamu/','192.168.32.226','2012-10-30 23:17:47');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (83,'C0001','http://wings.msn.to/hamu/','192.168.64.81','2012-11-01 22:25:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (84,'A0001','http://wings.msn.to/hamu/','192.168.15.76','2012-11-01 23:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (85,'B0003','http://wings.msn.to/kame/','192.168.69.166','2012-11-01 23:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (86,'A0001','http://wings.msn.to/hamu/','192.168.14.204','2012-11-02 07:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (87,'A0001','http://wings.msn.to/hamu/','192.168.12.16','2012-11-03 04:10:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (88,'C0001','http://wings.msn.to/hamu/','192.168.31.11','2012-11-05 11:16:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (89,'A0001','http://wings.msn.to/hamu/','192.168.15.115','2012-11-05 20:18:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (90,'A0001','http://wings.msn.to/hamu/','192.168.29.206','2012-11-06 21:18:11');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (91,'C0001','http://wings.msn.to/hamu/','192.168.1.242','2012-11-07 23:11:54');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (92,'A0001','http://wings.msn.to/hamu/','192.168.2.212','2012-11-09 21:14:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (93,'C0001','http://wings.msn.to/hamu/','192.168.22.07','2012-11-10 21:18:50');
INSERT INTO access_log (log_id,page_id,ip_address,access_date) VALUES (94,'A0001','192.168.116.14','2012-11-15 23:17:48');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (95,'A0001','http://wings.msn.to/hamu/','192.168.30.202','2012-11-16 14:12:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (96,'A0001','http://wings.msn.to/hamu/','192.168.4.243','2012-11-16 23:10:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (97,'D0001','http://wings.msn.to/hamu/','192.168.43.206','2012-11-19 11:13:00');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (98,'A0001','http://wings.msn.to/hamu/','192.168.82.101','2012-11-21 14:18:41');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (99,'C0001','http://wings.msn.to/hamu/','192.168.166.16','2012-11-22 16:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (100,'A0001','http://wings.msn.to/hamu/','192.168.30.206','2012-11-23 20:19:11');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (101,'A0001','http://wings.msn.to/hamu/','192.168.5.241','2012-11-25 20:11:52');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (102,'A0001','http://wings.msn.to/hamu/','192.168.152.200','2012-11-27 05:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (103,'C0001','http://wings.msn.to/hamu/','192.168.42.118','2012-11-29 00:12:16');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (104,'A0001','http://wings.msn.to/hamu/','192.168.185.112','2012-12-09 20:24:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (105,'A0001','http://wings.msn.to/hamu/','192.168.210.236','2012-12-13 23:10:57');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (106,'A0001','http://wings.msn.to/hamu/','192.168.17.207','2012-12-16 15:18:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (107,'A0001','http://wings.msn.to/hamu/','192.168.207.132','2012-12-21 20:17:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (108,'C0001','http://wings.msn.to/hamu/','192.168.212.109','2012-12-24 23:14:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (109,'A0001','http://wings.msn.to/hamu/','192.168.166.19','2012-12-25 11:24:18');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (110,'A0001','http://wings.msn.to/hamu/','192.168.220.37','2012-12-26 21:25:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (111,'A0001','http://wings.msn.to/hamu/','192.168.32.214','2012-12-27 14:13:12');
INSERT INTO access_log (log_id,page_id,ip_address,access_date) VALUES (112,'A0001','192.168.31.226','2012-12-27 23:11:15');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (113,'C0001','http://wings.msn.to/hamu/','192.168.65.81','2012-12-29 07:17:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (114,'A0001','http://wings.msn.to/hamu/','192.168.19.76','2012-12-30 23:17:47');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (115,'B0004','http://wings.msn.to/neko/','192.168.70.166','2013-01-01 12:25:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (116,'C0001','http://wings.msn.to/tori/','192.168.15.201','2013-01-01 13:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (117,'A0001','http://wings.msn.to/hamu/','192.168.13.16','2013-01-01 22:25:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (118,'C0001','http://wings.msn.to/hamu/','192.168.32.14','2013-01-01 23:18:14');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (119,'A0001','http://wings.msn.to/hamu/','192.168.16.115','2013-01-02 07:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (120,'C0002','http://wings.msn.to/neko/','192.168.30.206','2013-01-02 14:11:17');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (121,'A0001','http://wings.msn.to/hamu/','192.168.195.112','2013-01-03 04:10:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (122,'C0003','http://wings.msn.to/saru/','192.168.209.236','2013-01-03 14:10:49');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (123,'A0001','http://wings.msn.to/hamu/','192.168.16.198','2013-01-05 11:16:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (124,'C0004','http://wings.msn.to/kame/','192.168.206.132','2013-01-05 13:16:12');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (125,'C0005','http://wings.msn.to/neko/','192.168.211.109','2013-01-05 17:18:19');
INSERT INTO access_log (log_id,page_id,referer,ip_address,access_date) VALUES (126,'C0001','http://wings.msn.to/hamu/','192.168.165.19','2013-01-05 20:18:19');


CREATE TABLE 
contents (
c_id CHAR(4) NOT NULL,
c_title NVARCHAR2(255),
next_id CHAR(4),
PRIMARY KEY (c_id)
);

INSERT INTO contents (c_id,c_title,next_id) VALUES ('A001','SQLについて','A011');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A011','データの取得1','A012');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A012','カラムの選択','A013');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A013','WHERE句の記述','A014');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A014','NULLと空白の扱い','A015');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A015','あいまい検索','A016');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A016','複数条件の連結（論理演算子）','A017');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A017','重複レコードの除去','A021');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A021','データの取得2','A022');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A022','順位付け','A023');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A023','ソート','A024');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A024','グルーピング','A025');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A025','グルーピング結果の絞り込み','A026');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A026','クロス集計','A027');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A027','サブクエリー','A028');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A028','演算子による集計','A029');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A029','複数表の結合','A031');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A031','更新系SQL','A032');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A032','レコードを1件挿入する','A033');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A033','サブクエリで複数レコードを挿入する','A034');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A034','全レコード一律の更新を行う','A035');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A035','特定行の更新を行う','A036');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A036','特定レコードの削除を行う','A037');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A037','トランザクション','A041');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A041','データベースの作成','A042');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A042','データベースの作成／削除','A043');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A043','制約条件','A044');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A044','テーブルの作成／削除','A045');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A045','テーブル情報の変更','A046');
INSERT INTO contents (c_id,c_title,next_id) VALUES ('A046','インデックスの作成／削除','A047');
