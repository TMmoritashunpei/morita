var particles = Particles.init({
  selector: '.background',
  sizeVariations: 30,
  color: ['#aaa6a0', '#073d0c', '#d5edd7','#efd1ac','#f28f4d'],
});

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
  var _return_value = "";
  
//入力値の半角数字チェック
function check_numtype(obj){

   // ２．変数の定義
   var txt_obj = $(obj).val();
   var text_length = txt_obj.length;

   // ３．入力した文字が半角数字かどうかチェック
   if(txt_obj.match(/^[0-9]+$/)){
       // ３．１．文字数チェック
       if(text_length > 9){
           $('input[name="price"]').val(_return_value);
       }else{
           _return_value = txt_obj;
       }
   }else{
       // ３．２．入力した文字が半角数字ではないとき
       if(text_length == 0){
           $('input[name="price"]').val("");
           _return_value = "";
       }else{
           $('input[name="price"]').val(_return_value);
       }
   }
}
  
});