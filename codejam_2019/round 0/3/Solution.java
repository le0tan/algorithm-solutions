import java.util.*;
import java.math.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 1; t<=T; t++) {
      BigInteger n = new BigInteger(sc.next());
      int l = sc.nextInt();
      BigInteger[] map = new BigInteger[l+1];
      BigInteger[] in = new BigInteger[l];
      TreeSet<BigInteger> set = new TreeSet<>();
      for(int i=0;i<l;i++) {
        in[i] = new BigInteger(sc.next());
      }
      for(int i=0;i<l-1;i++) {
        if(!in[i].equals(in[i+1])) {
          map[i+1] = in[i].gcd(in[i+1]);
          set.add(map[i+1]);
        }
      }

      if(map[1]!=null) { 
        map[0] = in[0].divide(map[1]);
        set.add(map[0]);
      }

      if(map[l-1]!=null) {
        map[l] = in[l-1].divide(map[l-1]);
        set.add(map[l]);
      }

      int pos = -1;
      for(int i=0;i<=l;i++) {
        if(map[i]!=null) {
          pos = i;
          break;
        }
      }

      for(int i=pos+1;i<=l;i++) {
        if(map[i]==null) {
          map[i] = in[i-1].divide(map[i-1]);
          set.add(map[i]);
        }
      }

      for(int i=pos-1;i>=0;i--) {
        if(map[i]==null) {
          map[i] = in[i].divide(map[i+1]);
          set.add(map[i]);
        }
      }

      if(map[l]==null) {
        map[l] = in[l-1].divide(map[l-1]);
        set.add(map[l]);
      }

      HashMap<BigInteger, Character> hash = new HashMap<>();

      char alpha = 'A';
      for(BigInteger bi: set) {
        hash.put(bi, alpha++);
      }
      
      System.out.printf("Case #%d: ", t);
      for(int i=0;i<=l;i++) {
        System.out.print(hash.get(map[i]));
      }
      System.out.println();
    }
  }
}
