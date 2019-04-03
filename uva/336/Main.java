import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = 0;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			HashMap<Integer, List<Integer>> G = new HashMap<>(n);
			for(int i=0;i<n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(G.get(a)==null) G.put(a, new ArrayList<Integer>());
				G.get(a).add(b);
				if(G.get(b)==null) G.put(b, new ArrayList<Integer>());
				G.get(b).add(a);
			}
			while(true) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a==0 && b==0) break;
				// find shortest path from a to b
				Queue<Integer> q = new LinkedList<>();
				q.add(a);
				HashMap<Integer, Integer> d = new HashMap<>(n);
				for(Integer k: G.keySet()) {
					d.put(k, Integer.MAX_VALUE);
				}
				d.put(a, 0);
				while(!q.isEmpty()) {
					int cur = q.poll();
					int dis = d.get(cur);
					for(Integer k: G.get(cur)) {
						if(d.get(k)==Integer.MAX_VALUE) { 
							d.put(k, dis+1);
							q.add(k);
						}
					}
				}
				int cnt = 0;
				for(Integer v: d.values())
					if(v>b) cnt++;
				System.out.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.\n", ++cases, cnt, a, b);
			}
		}
	}
}

