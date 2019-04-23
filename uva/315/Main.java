import java.util.*;
import java.io.*;

public class Main {
  int time = 0;
  List<List<Integer>> g;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void dfs(int u, boolean[] vis, int[] disc, int[] low, int[] parent, boolean[] res) {
    int count = 0;
    vis[u] = true;
    disc[u] = low[u] = ++time;
    for(Integer v: g.get(u)) {
      if(!vis[v]) {
        count++;
        parent[v] = u;
        dfs(v, vis, disc, low, parent, res);
        low[u] = Math.min(low[u], low[v]);
        if(parent[u]==-1 && count>=2) res[u] = true;
        if(parent[u]!=-1 && low[v]>=disc[u]) res[u] = true; 
      } else if(v != parent[u]) {
        low[u] = Math.min(low[u], disc[v]);
      }
    }
  }

  private boolean[] calc(int n) {
    boolean[] vis = new boolean[n];
    int[] parent = new int[n];
    int[] low = new int[n];
    int[] disc = new int[n];
    boolean[] res = new boolean[n];
    for(int i=0;i<parent.length;i++)
      parent[i] = -1;
    dfs(0,vis,disc,low,parent,res);
    return res;
  }
  private void run() {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int n = sc.nextInt();
      sc.nextLine();
      if(n==0) break;
      g = new ArrayList<>();
      for(int i=0;i<n;i++)
        g.add(new ArrayList<>());
      while(true) {
        try {
          String[] s = sc.nextLine().split(" ");
          int[] a = new int[s.length];
          for(int i=0;i<s.length;i++) {
            a[i] = Integer.parseInt(s[i]);
          }
          if(a[0] == 0) break;
          for(int i=1;i<a.length;i++) {
            g.get(a[0]-1).add(a[i]-1);
            g.get(a[i]-1).add(a[0]-1);
          }
          // break;
        } catch (Exception ex) { 
          System.err.println(ex);
        }
      }
      boolean[] res = calc(n);
      int cnt = 0;
      for(boolean b: res) 
        if(b) cnt++;
      System.out.println(cnt);
    }
  }
  public static void main(String[] args) {
    Main m = new Main();
    m.run();
  }
}