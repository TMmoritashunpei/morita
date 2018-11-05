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
});