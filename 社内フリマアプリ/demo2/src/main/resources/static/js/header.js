$(function() {
	$('#contact-show').click(function() {
		$('#contact-modal').fadeIn();
	});
	$('#login-show').click(function() {
		$('#login-modal').fadeIn();
	});
	$('.signup-show').click(function() {
		$('#signup-modal').fadeIn();
	});
	//モーダルをクローズさせる
	$('.close-modal').click(function(){
		$('#login-modal').fadeOut();
		$('#contact-modal').fadeOut();
		$('#signup-modal').fadeOut();
	});
	$('.catagory-items').click(function(){
		var $nest = $(this).find('.nest');
		if($nest.hasClass('open')) {
			$nest.removeClass('open');
			$nest.slideUp();
		} else {
			$nest.addClass('open');
			$nest.slideDown();
		}
	});
});
function CheckPassword(confirm){
	// 入力値取得
	var input1 = password.value;
	var input2 = confirm.value;
	// パスワード比較
	if(input1 != input2){
		confirm.setCustomValidity("入力値が一致しません。");
	}else{
		confirm.setCustomValidity('');
	}
}