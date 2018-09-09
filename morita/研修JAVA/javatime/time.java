import java.time.*;
import java.time.format.*;

public class time {
  public static void main(String[] args) {
    DataTimeFormatter f = DataTimeFormatter.ofPattern("yyyy/mm/dd");
    LocalDate d = LocalDate.parse("2011/08/21, f");
    d = d.plusDays(1000);
    String str = d.format(f);
    System.out.println("1000日後は" + str);
  }
}
