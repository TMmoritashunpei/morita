
// エラー用グローバル変数
var e_message = "";

// エラーメッセージの更新
function del(err, sen){
	console.log(err);
	console.log(e_messagee);
	var parent = err.parentElement;
	var child = parent.getElementsByClassName("aft");
	if(child.length != 0){
		child[0].remove();
	}

	var child = document.createElement("p");
	child.innerHTML = sen;
	child.className = "aft";
	parent.appendChild(child);
	e_message = '';
}

// 半角が含まれていたらFalseを表示する。
function CheckLength(str,flg) {
	for (var i = 0; i < str.length; i++) {
		var c = str.charCodeAt(i);
		if ( (c >= 0x0 && c < 0x81) || (c == 0xf8f0) || (c >= 0xff61 && c < 0xffa0) || (c >= 0xf8f1 && c < 0xf8f4)) {
			if(!flg) return true;
		} else {
		if(flg) return true;
		}
	}
	return false;
}

// 各inputの要素を取得する。
var nam = document.getElementById("name");
var mail = document.getElementById("mail");
var age = document.getElementById("age");
var tel = document.getElementById("tel");
var ad = document.getElementById("ad");

// 名前に関してフォーカスが外れた時の処理を追加
nam.addEventListener('blur', function(){
	// Validation処理
	if(this.value.length > 10){
		e_message = "10文字以内で入力してください。";
	} else if(this.value == ""){
		e_message = "名前が入力されていません。";
	} else if(CheckLength(this.value, 0)){
		e_message = "半角文字が含まれています。";
	}
	del(this, e_message);});

// メールに関してフォーカスが外れた時の処理を追加
mail.addEventListener('blur', function(){
	// Validation処理
	var reg = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}\.[A-Za-z0-9]{1,}$/;
	if(this.value == ""){
		e_message = "メールアドレスが入力されていません。";
	}else if(!(reg.test(this.value))){
		e_message = "メールアドレスが不正です。";
	}
	del(this, e_message);});

// 年齢に関してフォーカスが外れた時の処理を追加
age.addEventListener('blur', function(){
	// Validation処理
	if(!(isNaN(this.value))){
		if(this.value < 0 || this.value > 120){
			e_message = "そんな年齢の人は存在しません。";
		} else if(this.value == ""){
			e_message = "年齢が入力されていません。";
		}
	}else{
		e_message = "数字ではありません。";
	}
	del(this, e_message);});

// 年齢に関してフォーカスが外れた時の処理を追加
tel.addEventListener('blur', function(){
	// Validation処理
	var tel = /^(0[5-9]0[0-9]{8}|0[1-9][1-9][0-9]{7})$/;
	if(!(tel.test(this.value.replace(/[━.*‐.*―.*－.*\-.*ー.*\-]/gi,'')))){
		e_message = "電話番号が不正です。";
	} else if(this.value == ""){
		e_message = "電話番号が入力されていません。";
	}
	del(this, e_message);});

// 年齢に関してフォーカスが外れた時の処理を追加
ad.addEventListener('blur', function(){
	// Validation処理
	if(this.value.length > 50){
		e_message = "住所が長すぎます。";
	} else if(this.value == ""){
		e_message = "住所が入力されていません。";
	} else if(CheckLength(this.value, 0)){
		e_message = "半角が含まれています。";
	}
	del(this, e_message);
});
