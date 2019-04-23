import java.util.*;

public class Solution {

  private void run() {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(), N = sc.nextInt(), M = sc.nextInt();
    while(T-- > 0) {
      int[] mod = new int[20];
      for(int i=2;i<=18;i++) {
        String out = "";
        out += i;
        for(int k=0;k<17;k++)
          out += " "+i;
        System.out.println(out);
        System.out.flush();
        int[] blades = new int[18];
        int cnt = 0;
        for(int k=0;k<18;k++) {
          blades[k] = sc.nextInt();
          cnt = (cnt+blades[k])%i;
        }
        mod[i] = cnt;
      }
      for(int i=0;i<=M;i++) {
        boolean ok = true;
        for(int m=2;m<=18;m++)
          if(i%m != mod[m]) {
            ok = false;
            break;
          }
        if(ok) {
          System.out.println(i);
          int status = sc.nextInt();
          if(status==-1) return;
          System.out.flush();
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.run();
  }
}
