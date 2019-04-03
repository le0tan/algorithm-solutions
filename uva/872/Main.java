import java.util.*;

public class Main {

	List<List<Integer>> adj;
	List<Integer> res;
	boolean[] vis;
	HashMap<String, Integer> map;
	String[] chars;

	private void dfs(int[] in) {
		boolean ok = false;
		for(int i=0;i<adj.size();i++) {
			if(!vis[i] && in[i]==0) {
				ok = true;
				res.add(i);
				vis[i] = true;
				for(Integer to: adj.get(i)) {
					in[to]--;	
				}
				dfs(in);
				vis[i] = false;
				for(Integer to: adj.get(i)) {
					in[to]++;
				}
				res.remove(res.size()-1);
				// System.out.println(res.size());
			}
		}
		if(!ok) {
			if(res.size()>0) System.out.print(chars[res.get(0)]);
			for(int i=1;i<res.size();i++) System.out.print(" "+chars[res.get(i)]);
			System.out.println();
		}
	}

	private boolean ddfs(int n, boolean[] back) {
		if(!vis[n]) {
			vis[n] = true;
			back[n] = true;
			for(Integer i: adj.get(n)) {
				if(!vis[i] && ddfs(i, back)) return true;
				if(back[i]) return true;
			}
		}
		back[n] = false;
		return false;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int ii=0;ii<T;ii++) {
			sc.nextLine();
			chars = sc.nextLine().split(" ");
			Arrays.sort(chars);
			String[] edges = sc.nextLine().split(" ");
			adj=new ArrayList<>();
			res=new ArrayList<>();
			int n = chars.length;
			int[] in = new int[n];
			vis = new boolean[n];
			map = new HashMap<>();
			for(int i=0;i<n;i++) {
				adj.add(new ArrayList<>());
				map.put(chars[i],i);
			}
			for(int i=0;i<edges.length;i++) {
				int a = map.get(edges[i].substring(0,1));
				int b = map.get(edges[i].substring(2,3));
				in[b]++;
				adj.get(a).add(b);
			}
			boolean ok = true;
			boolean[] back = new boolean[n];
			for(int i=0;i<n;i++) {
				if(!vis[i] && ddfs(i, back)) {
					System.out.println("NO");
					ok = false;
					break;
				}
			}
			if(ok) {
				vis = new boolean[n];
				dfs(in);	
			}
			if(ii<T-1) System.out.println();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
