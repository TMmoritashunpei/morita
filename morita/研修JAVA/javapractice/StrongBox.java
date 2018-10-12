import java.util.*;
enum KeyType {PADLOCK, BUTTON, DIAL, FINGER;}

public class StrongBox<E> {
  public static void main(String[] args) {
    private KeyType KeyType;
    private E item;
    private long count;
    public StrongBox(KeyType key) {
      this.KeyType = key;
    }
  public void put(E i) {
    this.item = i;
  }
  puclic E get() {
    this.count++;
    switch(this.KeyType) {
      case PADLOCK:
      if (cont < 1024) return null;
      break;
      case BUTTON:
      if (count < 10000) return null;
      break;
      case DIAL:
      if (count < 30000) return null;
      break;
      case FINGER:
      if (count < 100000) return null;
      break;
    }
    this.count = 0;
    return this.item;
  }
  }
}
