import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine(); sc.nextLine();
    while(T-- > 0) {
      TreeMap<String, Integer> map = new TreeMap<>();
      int total = 0;
      while(sc.hasNextLine()) {
        String s = sc.nextLine();
        if(s.length()==0) break;
        total++;
        if(!map.containsKey(s)) map.put(s, 1);
        else map.put(s, map.get(s)+1);
      }
      for(Map.Entry<String, Integer> e: map.entrySet()) {
        System.out.printf("%s %.4f\n", e.getKey(), (double)e.getValue() / total * 100.0);
      }
      if(T!=0) System.out.println();
    }
  }
}
