import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-- > 0) {
      int n = sc.nextInt();
      Set<Integer> set = new TreeSet<>();
      int max_length = 0;
      int last = 0;
      int[] input = new int[n];
      for(int i=0;i<n;i++) {
        input[i] = sc.nextInt();
        if(set.contains(input[i])) {
          while(input[last]!=input[i]) {
            set.remove(input[last]);
            last++;
          }
          set.remove(input[last]);
          last++;
        }
        set.add(input[i]);
        max_length = Math.max(max_length, i-last+1);
      }
      System.out.println(max_length);
    }
  }
}
