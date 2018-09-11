import java.util.*;
public class Hero3 {
  private String name;
  public Hero3(String name) {this.name = name;}
  public String getName() {return this.name;}
  public static void main(String[] args) {
    Hero h1 = new Hero("斎藤");
    Hero h2 = new Hero("鈴木");
    List<Hero> heros = new ArrayList<Hero>();
    heros.add(h1);
    heros.add(h2);
    for(Hero h : heros)
    System.out.println(h.getName());
  }
}
