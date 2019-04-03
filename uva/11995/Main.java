import java.util.*;
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      if(!sc.hasNext()) break;
      int n = sc.nextInt();
      boolean s = true;
      boolean q = true;
      boolean p = true;
      Stack<Integer> stack = new Stack<>();
      Queue<Integer> queue = new ArrayDeque<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
      for(int i=0;i<n;i++) {
        int c = sc.nextInt();
        int t = sc.nextInt();
        // System.out.printf("(%d,%d)\n",c,t);
        if(c==1) {
          if(s) stack.push(t);
          if(q) queue.add(t);
          if(p) pq.add(t);
        } else {
          if(s&&(stack.isEmpty()||stack.pop()!=t)) s = false;
          if(q&&(queue.isEmpty()||queue.poll()!=t)) q = false;
          if(p&&(pq.isEmpty()||pq.poll()!=t)) p = false;
        }
        // System.out.println(s+" "+q+" "+p);
      }
      if(s&&!q&&!p) System.out.println("stack");
      else if(!s&&q&&!p) System.out.println("queue");
      else if(!s&&!q&&p) System.out.println("priority queue");
      else if(!s&&!q&&!p) System.out.println("impossible");
      else System.out.println("not sure");
    }
  }
}
