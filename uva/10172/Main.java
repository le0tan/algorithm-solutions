import java.util.*;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-- > 0) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int q = sc.nextInt();
      Stack<Integer> stack = new Stack<>();
      List<Queue<Integer>> stations = new ArrayList<>();
      stations.add(new ArrayDeque<>());
      int cnt = 0;
      for(int i=1;i<=n;i++) {
        int t = sc.nextInt();
        cnt += t;
        stations.add(new ArrayDeque<>());
        for(int j=0;j<t;j++) {
          stations.get(i).add(sc.nextInt());
        }
      }
      int pos = 1;
      int time = 0;
      while(cnt>0) {
      	// System.out.printf("---Now at station %d---\n", pos);
        while(!stack.isEmpty() && (stack.peek()==pos || stations.get(pos).size()<q)) {
          if(stack.peek() != pos) {
            stations.get(pos).add(stack.peek());
          } else {
            cnt--;
          }
          stack.pop();
          time++;
        }
        while(!stations.get(pos).isEmpty() && stack.size()<s) {
          int k = stations.get(pos).poll();
          stack.push(k);
          // System.out.printf("Loads %d\n", k);
          time++;
        }
        if(cnt<=0) break;
        // boolean ok = stack.isEmpty();
        // for(int i=1;i<=n;i++) ok = ok && stations.get(i).isEmpty();
        // if(ok) break;
        else { pos = (pos+1 > n ? 1 : pos+1); time+=2; }
      }
      System.out.println(time);
    }
  }
}
