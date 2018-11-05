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
	$('.ctagory-items').click(function(){
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