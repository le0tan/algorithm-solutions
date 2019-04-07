import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int T=1;T<=n;T++) {
      int k = sc.nextInt();
      String s = sc.next();
      String res = "";
      for(int i=0;i<s.length();i++) {
        if(s.charAt(i)=='S') res+="E";
        else res+="S";
      }
      System.out.printf("Case #%d: %s\n", T, res);
    }
  }
}
