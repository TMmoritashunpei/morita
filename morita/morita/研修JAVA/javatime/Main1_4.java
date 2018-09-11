//イテレータ
import java.util.ArrayList;
import java.util.Iterator;

public class Main1_4 {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<String>();
    names.add("森田");
    names.add("隼");
    names.add("平");
    Iterator<String> it = names.iterator();
    //イテレータが矢印を次に進められるなら処理を繰り返す
    while(it.hasNext()) {
      //矢印を次に進め内容を取り出しeに代入
      String e = it.next();
      System.out.print(e);
    }
  }
}
