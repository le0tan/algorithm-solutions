import java.util.*;

public class Main {

	int count_false;
	int count_true;

	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			count_false = 1;
			int v = sc.nextInt();
			int e = sc.nextInt();
			List<List<Integer>> g = new ArrayList<>();
			for(int i=0;i<v;i++) g.add(new ArrayList<>());
			for(int i=0;i<e;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				g.get(a).add(b);
				g.get(b).add(a);
			}
			boolean[] vis = new boolean[v];
			boolean[] color = new boolean[v];
			int res = 0;
			boolean ok = true;
			for(int i=0;i<v;i++) {
				if(!vis[i]) {
					count_false = 0;
					count_true = 0;
					boolean t = calc(i,false,vis,color,g);
					//System.out.printf("%d %d\n", count_false, count_true);
					if(!t) { ok = false; break; }
					else res += count_false + count_true == 1 ? 1 : Math.min(count_false, count_true);
				}
			}

			if(ok) System.out.println(res);
			else System.out.println(-1);

		}
	}

	private boolean calc(int n, boolean c, boolean[] vis, boolean[] color, List<List<Integer>> g) {
		if(vis[n]) {
			if(c != color[n]) return false;
			else return true;
		} else {
			vis[n] = true;
			color[n] = c;
			if(!c) count_false++;
			else count_true++;
			for(Integer i: g.get(n)) if(!calc(i, !c, vis, color, g)) return false;
			return true;
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
