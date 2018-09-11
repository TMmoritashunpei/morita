import java.time.*;
import java.time.format.*;

public class Main1_2 {
  public static void main(String[] args) {
  //文字列からLocalDataを作成
  DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  LocalDate d = LocalDate.parse("2011/08/21", f);
  LocalDate d2 = LocalDate.new();
  //1000日後を計算する
  d = d.plusDays(1000);
  String str = d.format(f);
  d2 = d2.minusDays(1000);
  String str = d.format(f);
  String str2 = d2.format(f);
  System.out.println("1000日後は" + str);
  System.out.println("1000日前は" + str2);
  //現在日付けとの比較
  LocalDate now = LocalDate.now();
  if (now.isAfter(d)) {
    System.out.println("nowはdより新しい");
    }
  }
}
