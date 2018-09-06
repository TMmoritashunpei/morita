var practice = document.getElementById("practice");
practice.innerHTML = '<h1>れんしゅう</h1>';
practice.style.backgroundColor = '#999999';
practice.style.fontSize = '30px';
practice.style.color = '#FFFFFF';
var first = document.createElement('div');
first.setAttribute('id', 'first');
first.innerHTML = '<p>要素を追加</p>';
//
practice.insertBefore(first, null);
var second = document.createElement('div');
second.setAttribute('id', 'second');
second.innerHTML = '<p>さらに要素を追加</p>';
practice.insertBefore(second, first);
//親要素を取得してから子要素を削除します。
var parent = first.parentElement;// 親要素はbodyになる
parent.removeChild(first);
