/**
 * 
 */
window.onload = function(){
var mail = document.getElementById("password_addr_repeat");
mail.addEventListener("input", function() {
  if (this.value != document.getElementById('password_addr').value) {
    this.setCustomValidity('確認入力されたパスワードが異なります');
  } else {
    // input is valid -- reset the error message
    this.setCustomValidity('');
  }
});
  // 入力値チェックエラーが発生したときの処理
  form.addEventListener("invalid", function() {
    document.getElementById("errorMessage").innerHTML = "入力値にエラーがあります";
  }, false);
}