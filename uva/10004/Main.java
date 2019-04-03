import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int l = sc.nextInt();
			List< List<Integer> > adj = new ArrayList<>();
			for(int i=0;i<n;i++) adj.add(new ArrayList<>());
			for(int i=0;i<l;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj.get(a).add(b);
			}
			boolean[] color = new boolean[n];
			boolean[] vis = new boolean[n];
			if(dfs(0,color,adj,vis,true)) {
				System.out.println("NOT BICOLORABLE.");
			} else {
				System.out.println("BICOLORABLE.");
			}
		}
	}

	private static boolean dfs(int n, boolean[] color, List<List<Integer>> adj, boolean[] vis, boolean tc) {
		if(vis[n]) {
			if(color[n] != tc) return true;
		} else {
			vis[n] = true;
			color[n] = tc;
			for(Integer i: adj.get(n)) {
				if(dfs(i,color,adj,vis,!tc)) return true;
			}
		}
		return false;
	}
}
