import java.util.Scanner;
public class Main1_6 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String  name = scanner.next();
    boolean chk;
    chk = isValidPlayerName(name);
    if(chk) {
      System.out.println("名前は" + name);
    } else {
      System.out.println("違います");
     }
   }

    static boolean isValidPlayerName(String name) {
    if (name.matches("[\\w][-@+\\*;:#$%&!.\\w]{1,20}")) {
      return true;
    } else {
      return false;
    }
  }
}

/*正規表現-は一番最初に入れておかないと反応しない\\wで大文字から小文字まで入力可能
(".*")任意の一文字以上の無制限の繰り返し。
これだけでは使わない。
｛｝指定回数の繰り返し。
\d 椅子れかの数字0-9
デシマル 10進数
\w英字数字アンダーバー
\s空白文字
^先頭文字
$終わり文字
^j.*p$　jから始まりpで終わる中身は任意の一文字以上
拡張for文
配列もしくはlist

プレースホルダ―
場所を保持している
String.format("")
空き領域ゼロ埋めのこと
ゼロパディング
ゼロサプレス
ゼロをなくすこと


可変長引数...

スレッド
複数処理
timeAPI

equals オーバーライドするべきメソッド

rimeapi　あいまいな持ち方ができる
5月5日はこどもの日みたいな使い方ができるようになっている。

パース
parse
解析という事


コレクションを知らないとダメ
配列　array　

リスト
セット

マップ
キーバリュー方式
キーが呼び出すと呼ぶ出される
ハッシュマップ
二つの値が入る
map mp = new hashMap
mpにいくつもキーバリューが入っている

list
arraylist
import java.utilArraylist;
リストはgetで取る
<>ジェネリクス
インスタンスがnewしてバラバラに扱うのは面倒なのでリストで取ってくることができる。
立ち上がったインスタンスをリストに入れる
new Arraylist<String>()
add();
listはインスタンスしか入れられない
配列はメモリ効率が高い
<Integer>にすればオートボクシング
機能使える。
数値なども扱うことができる。
ArrayList<>変数名
イテレータ
for文のように使える
何を使うのか組み合わせは性能に直結してくる
削除する
clear()すべて削除される。
remove()要素削除
for文は遅い
リストと
拡張for文

中身を書き換える場合はlinkdlistを使う
要素の取得はArrylist

set重複許されない
基本的に順番が関係ない。
インデックスは使えない
treeset辞書順になる。

Map
キーバリュー
DBにもある
NOSQL
モンゴDBダイナモDB

リレーショナルDB
RDBS
MYsql
postgras


map
Map <String Intager>型
put();
get();
size()
remove()
値の重複しても許されるがキーの重複は許されない。
*/
