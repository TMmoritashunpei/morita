import java.time.*;
import java.time.format.*;
import java.util.Calendar;
public class Main1_3 {
  public static void main(String[] args) {
    //現在の日時をDate形で取得
    Date now = new Date();
    Calendr c = Calender.getInstance();
    //取得した日時情報をcalenderにセット
    c.setTime(now);
    calenderから「日」の情報を取得
    int day = c.get(Calender.DAY_OF_MONTH);
    収得した値に100を足してcalenderの「日」をセット
    day += 100;
    c.set(Calender


  }
}
