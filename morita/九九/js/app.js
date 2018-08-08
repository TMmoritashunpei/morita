document.write("<center>");
document.write("<h1>掛け算九九の表</h1>");
document.write("<table border>");

for(var i = 1 ; i < 10 ; i++) {
  document.write("<tr>");

  for(var j = 1 ; j < 10 ; j++) {
    document.write("<td>", i*j , "</td>");
  }
  document.write("</tr>");

}
document.write("</table>");
document.write("</center>");
$(function() {
  $("center").attr('id','kuku');
});
$('kuku').css('padding','80px');
