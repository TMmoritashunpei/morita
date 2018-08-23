document.write("<h1>掛け算九九の表</h1>");
document.write("<table border>");

for(var i = 1 ; i < 10 ; i++) {
  document.write("<tr>");

  for(var j = 1 ; j < 10 ; j++) {
    if(i * j <10) {
      document.write("<td>&nbsp&nbsp", i*j ,"</td>")
    }else{
    document.write("<td>", i*j , "</td>");
  }
  }
  document.write("</tr>");

}
document.write("</table>");
