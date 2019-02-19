INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id) 
VALUES('item', 1000, 'good', 'pay', 3, 'nice', 1, 2);
INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id) 
VALUES('item2', 1000, 'good', 'pay', 3, 'nice', 2, 1);
INSERT INTO items(item_name, price, conditions, payment, stock, comments, user_id, category_id) 
VALUES('item3', 1000, 'good', 'pay', 3, 'nice', 2, 1);

INSERT INTO users(username, password, tel, mail, comments) 
VALUES('techma', '997f8d664d976118f473e3c012a2fa4018cb5cb34ff4cfe065968b278a8b5dd8513b91b06ca2ee36'/*techma*/, '080-3663-8899', 'techma@i.softbank.jp', 'こんにちは');

INSERT INTO users(username, password, tel, mail, comments) 
VALUES('test', '600f2c5bef2d2b0b0b150858bfdf4c349ba89a45562e8ff6b6e9eb54f81a128c43ba5a199fe7dbe1', '080-3663-8899', 'techma@i.softbank.jp', 'おはよう');

INSERT INTO categorys(category_name) 
VALUES('mensファッション');

INSERT INTO categorys(category_name) 
VALUES('ladiesファッション');

INSERT INTO categorys(category_name) 
VALUES('kidsファッション');

INSERT INTO categorys(category_name) 
VALUES('book');

INSERT INTO categorys(category_name) 
VALUES('mudic　・　game');

INSERT INTO categorys(category_name) 
VALUES('ハンドメイド');

INSERT INTO categorys(category_name) 
VALUES('ホビー');

INSERT INTO categorys(category_name) 
VALUES('サービス、その他');