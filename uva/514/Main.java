import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int n = sc.nextInt();
      if(n==0) break;
      int[] in = new int[n];
      for(int i=1;i<=n;i++) in[i-1] = i;
      while(true) {
        int[] a = new int[n];
        a[0] = sc.nextInt();
        if(a[0]==0) break;
        for(int i=1;i<n;i++) a[i] = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        int p = 0;
        for(int i=0;i<n;i++) {
          if(in[i]==a[p]) {
            p++;
            while(!s.isEmpty() && s.peek()==a[p]) {
              s.pop();
              p++;
            }
          } else s.push(in[i]);
        }
        while(!s.isEmpty() && s.peek()==a[p]) {
          s.pop(); p++;
        }
        if(s.isEmpty()) System.out.println("Yes");
        else System.out.println("No");
      }
      System.out.println();
    }
  }
}