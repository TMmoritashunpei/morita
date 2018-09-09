import java.util.*;

public class Main1_6 {
  public static void main(String[] args) {
    Map<String, Integer> prefs = new HashMap<String, Integer>();
    prefs.put("京都府", 255);
    prefs.put("東京都",1261);
    prefs.put("熊本県",182);
    for(String key : prefs.keySet()) {
      int value = prefs.get(key);
      System.out.println(key + "の人口は" + value);
    }
      System.out.printf("製品番号%s-%02d","SVJ",3);
  }
}


/*拡張for文
equals() hashCode()
toString
のオーバーライド
コレクション
性能によって使い分ける
クラスの実体＝インスタンス

objectクラス
バグの温床になるが
変数の値などを調べるにはいいこともある。
tostring
equals
hashCode
compare
clone
tostring インスタンスを代入しても文字が読めない
オーバーライドすれば見れるようになる。
@オーバーライドはつける

等値　等価
等値は完全一致
何をもって等価という定義をするために
オーバーライドする必要がある。

件数が多いとき大体同じか
大体同じな要素にだけequalsで厳密に同じか問い合わせる
ハッシュ値
HashSetは大体同じかを判断するために
インすランスに対するハッシュ値というものを利用する

クラスという概念
型安全
コンパイルエラーが起きる
実行時エラーが起きる。
ジェネリクス=　総称型　テンプレートという。
<>
ダイヤモンド
*/
