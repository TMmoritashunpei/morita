$(function() {
  $('input[type=file]').after('<span></span>');
  
  // ‘アップロードするファイルを選択
  $('input[type=file]').change(function(e) {
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
  $('.pic-control').click(function() {
	  $('.pic-item .noimg').hide();
  }) 
  $('.pic-control2').click(function() {
	  $('.pic-item2 .noimg').hide();
  }) 
  $('.pic-control3').click(function() {
	  $('.pic-item3 .noimg').hide();
  }) 
  $('.pic-control4').click(function() {
	  $('.pic-item4 .noimg').hide();
  }) 
  $('#cancel').click(function() {
	  $('.pic-item img').hide();
	  $('.pic-control').val("");
	  $('.pic-item .noimg').show();
  })
  $('#cancel2').click(function() {
	  $('.pic-item2 img').hide();
	  $('.pic-control2').val("");
	  $('.pic-item2 .noimg').show();
  })
  $('#cancel3').click(function() {
	  $('.pic-item3 img').hide();
	  $('.pic-control3').val("");
	  $('.pic-item3 .noimg').show();
  })
   $('#cancel4').click(function() {
	  $('.pic-item4 img').hide();
	  $('.pic-control4').val("");
	  $('.pic-item4 .noimg').show();
  })
   $('input[type=button]#cansel2').click(function() {
	  $('img').remove()
	  $('#file2').val("");
	  $('.pic-control').append('<img src="/image/No_Image_Available.jpg">')
  })
});