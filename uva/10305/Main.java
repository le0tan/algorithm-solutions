import java.util.*;

public class Main {

  public static List< List<Integer> > g;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n=sc.nextInt(), m=sc.nextInt();
			if(n==0&&m==0) break;
			g = new ArrayList<>();
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
      for(int i=1;i<=n;i++) if(!vis[i]) dfs(i,vis,res);
      Collections.reverse(res);

			if(res.size()>0) {
				System.out.print(res.get(0));
				for(int i=1;i<res.size();i++)
					System.out.print(" "+res.get(i));
				System.out.println();
			}
		}
	}
  private static void dfs(int n, boolean[] vis, List<Integer> res) {
    vis[n] = true;
    for(Integer i: g.get(n)) {
      if(!vis[i]) dfs(i,vis,res);
    }
    res.add(n);
  }
}