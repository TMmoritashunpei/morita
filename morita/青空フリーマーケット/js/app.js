

var hiduke = new Date();
var year = hiduke.getFullYear();
var month = hiduke.getMonth()+1;
var week = hiduke.getDay();
var day = hiduke.getDate();
var yobi= new Array("日","月","火","水","木","金","土");
$("#info dd:nth-child(4)").html(year+"年"+month+"月"+day+"日"+"("+yobi[week]+")");
//element.innerHTML =year+"年"+month+"月"+day+"日"+"("+yobi[week]+")";






//var element = document.getElementById("row2");
//var hiduke=new Date();
//var year = hiduke.getFullYear();
//var month = hiduke.getMonth()+1;
//var week = hiduke.getDay();
//var day = hiduke.getDate();
//var yobi= new Array("日","月","火","水","木","金","土");
//element.innerHTML =year+"年"+month+"月"+day+"日"+"("+yobi[week]+")";
//console.log(year+"年"+month+"月"+day+"日 "+yobi[week]+"曜日");
