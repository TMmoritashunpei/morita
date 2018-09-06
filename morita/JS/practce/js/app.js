//フォームの要素を取得
var button = document.getElementById('button');
var form = document.getElementById('form');
var textarea = document.getElementById('textarea');
/* イベント処理*************/

//お問い合わせボタン押す
button.addEventListener('click', function() {

  form.style.display = 'block';  //フォームを表示
});

//Max文字制限取得
var maxTextNum = textarea.getAttribute('maxlength'); //getAttributeでmaxlengthの属性を取得

/*要素の追加****************/

//残り文字数を表示する要素の追加

var riminingTimeNum = 10; //残り時間

/*要素の追加残り文字数を表示する要素の追加*/
var textMessage = document.createElement('div');

var parent = textarea.parentElement; //textareaの親要素取得

parent.insertBefore(textMessage, textarea); //textareaに前にメッセージを入れる

//残り時間を表示する要素の追加
var timeMessage = document.createElement('div');
//textareaの親要素を取得してnullで子要素の一番最後に挿入
parent.insertBefore(timeMessage, null);
//タイマー処理で残り時間を表示setintervalメソッド追加
var timerId = setInterval(function() {
  timeMessage.innerHTML = '<p>制限時間：' + riminingTimeNum + '秒</p>';
  riminingTimeNum--;
},1000); //タイマーの間隔を指定


//テキストエリアでキーをタイプしたとき
textarea.addEventListener('keyup', function() {
  var currentTextNum = textarea.value.length; //valueはテキストエリアに入力された文字列を習得lengthで長さを調べる。
textMessage.innerHTML = '<p>あと「' + (maxTextNum - currentTextNum) + '」文字入力できます。</p>'
});
