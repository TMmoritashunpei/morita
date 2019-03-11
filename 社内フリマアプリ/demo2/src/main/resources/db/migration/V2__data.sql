INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id, created_at) 
VALUES('item', 1000, 'good', 'pay', 3, 'nice', 1, 2,'2019-03-07 21:13:50');
INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id, created_at) 
VALUES('item2', 1000, 'good', 'pay', 3, 'nice', 2, 1,'2019-03-07 21:13:50');
INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id, created_at) 
VALUES('item3', 1000, 'good', 'pay', 3, 'nice', 2, 1,'2019-03-07 21:13:50');

INSERT INTO users(username, password, tel, mail, comments,created_at) 
VALUES('techma', '997f8d664d976118f473e3c012a2fa4018cb5cb34ff4cfe065968b278a8b5dd8513b91b06ca2ee36'/*techma*/, '080-3663-8899', 'techma@i.softbank.jp', 'こんにちは', '2019-03-07 21:13:50');

INSERT INTO users(username, password, tel, mail, comments,created_at) 
VALUES('test', '600f2c5bef2d2b0b0b150858bfdf4c349ba89a45562e8ff6b6e9eb54f81a128c43ba5a199fe7dbe1', '080-3663-8899', 'techma@i.softbank.jp', 'おはよう', '2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('mensファッション','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('ladiesファッション','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('kidsファッション','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('book','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('mudic　・　game','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('ハンドメイド','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('ホビー','2019-03-07 21:13:50');

INSERT INTO categorys(category_name, created_at) 
VALUES('サービス、その他','2019-03-07 21:13:50');