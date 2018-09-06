var KEY = 'APIキー'; //API KEY
var url=''//API URL
url += 'type="video"'; //動画を検索する
url += '$part=snippet'; //検索ワードにすべてのプロパティを含む
url += '$q=music'; //検索ワードこのサンプルではmusicに指定
url += '&videoEmbeddable=true'; //webページに埋め込み可能な動画のみ検索
url += '&videoSyndicated=true'; //yotube.com以外で再生できる動画のみに限定
url += '&maxRusults=6'; //動画の最大取得件数
url += '&key=' + key; //APIキー

&(function() {
  $ajax({
    url: url,
    dataType :'jsonp'
  }).done(function(data) {

  }).fail(function(data) {
    alert('通信に失敗しました');
  });
});
function setData(data) {
  var result = '';
  var video = '';
  for (var i =0 i < data.items.length; i++) {
    video = '<iframe src="https://www.youtube.com/enbed/';
    video += data.items[i].id.videoId;
    video += ``
  }
}
