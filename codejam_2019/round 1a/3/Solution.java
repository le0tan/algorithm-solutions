import java.util.*;

public class Solution {

  private int calc(List<String> words) {
    List<List<Edge>> g = new ArrayList<>();
    for(int i=0;i<words.size();i++)
      g.add(new ArrayList<>());
    for(int i=0;i<words.size();i++) {
      for(int j=i+1;j<words.size();j++) {
        int len = 0;
        String a = words.get(i);
        String b = words.get(j);
        while(a.length()-len>=0 && 
              b.length()-len>=0 && 
              a.substring(a.length()-len,a.length()).equals(
              b.substring(b.length()-len,b.length()))) {
          // System.out.println(a.substring(a.length()-len,a.length()));
          // System.out.println(b.substring(b.length()-len,b.length()));
          len++;
        }
        // System.out.println(len-1);
        if(len-1>0) {
          g.get(i).add(new Edge(j,len-1));
          g.get(j).add(new Edge(i,len-1));
        }
      }
    }
    // for(int i=0;i<g.size();i++) {
    //   for(Edge e: g.get(i)) {
    //     System.out.printf("%d -> %d: %d\n", i,e.to,e.weight);
    //   }
    // }
    int cnt = 0;
    boolean[] vis = new boolean[words.size()];
    for(int i=0;i<g.size();i++) {
      // if(vis[i]) continue;
      // vis[i] = true;
      // if(g.get(i).size()==1) {
      //   int other = g.get(i).get(0).to;
      //   vis[other] = true;
      //   if(g.get(other).size()==1) {
      //     cnt += 2;
      //   }
      // }
      if(vis[i]) continue;
      vis[i] = true;
      for(Edge e: g.get(i)) {
        if(vis[e.to]) continue;
        int w = e.weight;
        boolean ok = true;
        for(Edge ee: g.get(e.to)) {
          if(ee.to != i && !vis[ee.to] && ee.weight >= w) {
            ok = false;
            break;
          }
        }
        if(ok) {
          cnt += 2;
          vis[e.to] = true;
          break;
        }
      }
    }
    return cnt;
  }

  private void run() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int kase=1;kase<=t;kase++) {
      int n = sc.nextInt();
      List<String> words = new ArrayList<>();
      for(int i=0;i<n;i++)
        words.add(sc.next());
      System.out.printf("Case #%d: %d\n", kase, calc(words));
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.run();
  }
}

class Edge {
  int to, weight;
  public Edge(int a, int b) {
    to = a; weight = b;
  }
}