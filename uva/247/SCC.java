import java.util.*;


public class Main {
	
  private List<List<Integer>> scc(List<List<Integer>> adj) {
    boolean[] vis = new boolean[adj.size()];
    List<List<Integer>> radj = new ArrayList<>();
    for(int i=0;i<adj.size();i++) radj.add(new ArrayList<>());
    for(int i=0;i<adj.size();i++) {
      for(Integer to: adj.get(i)) {
        radj.get(to).add(i);
      }
    }
    Stack<Integer> s = new Stack<>();
    List<List<Integer>> res = new ArrayList<>();
    for(int i=0;i<adj.size();i++) {
      if(!vis[i]) {
        dfs(i,adj,vis,s);
      }
    }
    boolean[] rvis = new boolean[adj.size()];
    while(!s.isEmpty()) {
      int cur = s.pop();
      if(!rvis[cur]) {
        List<Integer> tres = new ArrayList<>();
        res.add(tres);
        rdfs(cur,radj,rvis,tres);
      }
    }
    return res;
  }

  private void dfs(int n, List<List<Integer>> adj, boolean[] vis, 
      Stack<Integer> stack) {
    if(!vis[n]) {
      vis[n] = true;
      for(Integer i: adj.get(n)) {
        dfs(i,adj,vis,stack);
      }
      stack.push(n);
    }
  }
  
  private void rdfs(int n, List<List<Integer>> adj, boolean[] rvis, List<Integer> tres) {
    if(rvis[n]) return;
    rvis[n] = true;
    tres.add(n);
    for(Integer i: adj.get(n)) {
      rdfs(i,adj,rvis,tres);
    }
  }

	private void run() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0;i<n;i++) adj.add(new ArrayList<>());
    for(int i=0;i<m;i++) {
      int a = sc.nextInt(); int b = sc.nextInt();
      adj.get(a).add(b);
    }
    List<List<Integer>> res = scc(adj);
    for(List<Integer> l: res) {
      System.out.println("---");
      for(Integer i: l) {
        System.out.println(i);
      }
    }
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
