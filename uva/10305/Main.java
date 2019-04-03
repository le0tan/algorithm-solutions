import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n=sc.nextInt(), m=sc.nextInt();
			if(n==0&&m==0) break;
			List< List<Integer> > g = new ArrayList<>();
			int[] in = new int[n+1];
			for(int i=0;i<=n;i++) g.add(new ArrayList<>());
			for(int i=0;i<m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				g.get(a).add(b);
				in[b]++;
			}
			List<Integer> res = new ArrayList<>();
			boolean[] vis = new boolean[n+1];
			for(int i=1;i<=n;i++) {
				if(in[i]==0 && !vis[i]) {
					Queue<Integer> q = new ArrayDeque<>();
					q.add(i);
					vis[i] = true;
					while(!q.isEmpty()) {
						int cur = q.poll();
						res.add(cur);
						for(Integer t: g.get(cur)) {
							if(!vis[t]) {
								q.add(t);
								vis[t] = true;
							}
						}
					}
				}
			}
			if(res.size()>0) {
				System.out.print(res.get(0));
				for(int i=1;i<res.size();i++)
					System.out.print(" "+res.get(i));
				System.out.println();
			}
		}
	}
}
