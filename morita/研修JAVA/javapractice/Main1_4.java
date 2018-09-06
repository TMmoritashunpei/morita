public class Main1_4 {
  public static void main(String[] args){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 10000; i++) {
      sb.append("Java");
    }
    String s = sb.toString();
    System.out.println(s);
  }
}

/*メソッドチェーン自身の参照を繰り返していくのをメソッドチェーンという。
スレッドは並列処理
並列処理をするにはStrringBuffer
Stringクラスは特別な配慮
文字列情報はインスタンス化したら
二度と書き換えることにできない
immutableという
