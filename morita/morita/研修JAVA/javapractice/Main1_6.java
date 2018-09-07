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
*/
