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
    vis[n] = true;

    for(Integer i: adj.get(n)) {
      if(!vis[i]) dfs(i,adj,vis,stack);
    }

    stack.push(n);
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
    int T = 0;
    while(true) {
      T++;
      int n = sc.nextInt();
      int m = sc.nextInt();
      if(n==0 && m==0) break;
      List<List<Integer>> adj = new ArrayList<>();
      for(int i=0;i<n;i++) adj.add(new ArrayList<>());
      int cnt = 0;
      HashMap<String, Integer> map = new HashMap<>(n);
      List<String> names = new ArrayList<>();
      for(int i=0;i<m;i++) {
        String a = sc.next();
        String b = sc.next();
        if(!map.containsKey(a)) { map.put(a, cnt++); names.add(a); }
        if(!map.containsKey(b)) { map.put(b, cnt++); names.add(b); }
        adj.get(map.get(a)).add(map.get(b));
      }
      List<List<Integer>> res = scc(adj);
      System.out.printf("Calling circles for data set %d:\n", T);
      for(List<Integer> l: res) {
        if(l.isEmpty() || names.isEmpty()) continue;
        System.out.print(names.get(l.get(0)));
        for(int i=1;i<l.size();i++) System.out.printf(", %s", names.get(l.get(i)));
        System.out.println();
      }
    }
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
