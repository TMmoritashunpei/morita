//おみくじ結果データ作成
//results = ['大吉','吉','小吉','凶'];
//配列「results」をコンソールに表示
//console.log(results);

//インデックスが[０]の要素をコンソールに表示
//console.log(results[0]);

//for (var i = 0; i < results.length; i++) {
  //console.log('index:' + i + 'データ：' + results[i]);}

var omikuji = {
  results: ["大吉","吉","中吉","小吉","凶"],
  getRusult: function() {
    var results = this.results;
    return results [Math.floor(Math.random() * results.length)];
  }
}
var getResult = document.getElementById('getResult');
var result = document.getElementById('result');

getResult.addEventListener('click', function() {
  result.innerHTML = '結果は「' + omikuji.getRusult() + '」でした。';
});
