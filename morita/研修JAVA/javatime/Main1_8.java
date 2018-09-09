import java.util.*;

public class Main1_8 {
  public static void main(String[] args) {
  ArrayList<String> names = new ArrayList<String>();
  names.add("mori");
  names.add("shun");
  names.add("pei");
  Iterator<String> it = names.iterator();
  while (it.hasNext()) {
    String e = it.next();
    System.out.println(e);
    }
  }
}
