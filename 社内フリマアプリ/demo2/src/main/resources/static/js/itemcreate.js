$(function() {
  $('input[type=file]').after('<span></span>');
  
  // アップロードするファイルを選択
  $('input[type=file]').change(function(e) {
	  $('.noimg').remove()
    var file = $(this).prop('files')[0];
    
    // 画像以外は処理を停止
    if (! file.type.match('image.*')) {
      // クリア
      $(this).val('');
      $('span').html('');
      return;
    }

    // 画像表示
    var reader = new FileReader();
    reader.onload = function() {
      var img_src = $('<img>').attr('src', reader.result);
      img_src.css('width','220px');
      img_src.css('height','170px');
      $(e.target).next().html(img_src);
    }
    
    reader.readAsDataURL(file);
  });
  $('#cancel').click(function() {
	  $('.pic-item img').remove()
	  $('.pic-control').val("");
	 
  })
  $('#cancel2').click(function() {
	  $('.pic-item2 img').remove()
	  $('.pic-control2').val("");
  })
  $('#cancel3').click(function() {
	  $('.pic-item3 img').remove()
	  $('.pic-control3').val("");
  })
   $('#cancel4').click(function() {
	  $('.pic-item4 img').remove()
	  $('.pic-control4').val("");
  })
   $('input[type=button]#cansel2').click(function() {
	  $('img').remove()
	  $('#file2').val("");
  })
});