import java.util.*;

public class Main {
	
	int R,C,M,N;
	boolean[][] G;
	int[][] k;
	
	private Set<Pair> canReach(int r, int c) {
		int[] a = {M,M,-M,-M,N,N,-N,-N};
		int[] b = {N,-N,N,-N,M,-M,M,-M};
		Set<Pair> res = new HashSet<>();
		for(int i=0;i<8;i++) {
			if(r+a[i]>=0 && r+a[i]<R && c+b[i]>=0 && c+b[i]<C && !G[r+a[i]][c+b[i]]) {
				res.add(new Pair(r+a[i], c+b[i]));
			}
		}
		return res;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int ii=0;ii<T;ii++) {
			R = sc.nextInt(); C=sc.nextInt(); M=sc.nextInt(); N=sc.nextInt();
			G=new boolean[R][C]; k = new int[R][C];
			for(int i=0;i<R;i++) for(int j=0;j<C;j++) k[i][j]=-1;
			int W = sc.nextInt();
			for(int i=0;i<W;i++) {
				G[sc.nextInt()][sc.nextInt()]=true;
			}
			Queue<Pair> q = new ArrayDeque<>();
			q.add(new Pair(0,0));
			int odd = 0;
			int even = 0;
			boolean[][] vis = new boolean[R][C];
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				vis[cur.first][cur.second] = true;
				Set<Pair> pend = canReach(cur.first, cur.second);
				k[cur.first][cur.second] = pend.size();
				if(pend.size()%2==0) even++;
				else odd++;
				for(Pair p: pend) {
					if(k[p.first][p.second]==-1 && !vis[p.first][p.second]) {
						q.add(p);
						vis[p.first][p.second] = true;
					}
				}
			}
			System.out.printf("Case %d: %d %d\n", ii+1, even, odd);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}

class Pair {
	int first, second;
	public Pair(int a,int b) {
		first = a;
		second = b;
	}
	@Override
	public String toString() {
		return String.format("(%d, %d)", first, second);
	}
	@Override
	public int hashCode() {
		return (first*37+second*39)%47;
	}
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Pair)) return false;
		Pair other = (Pair) o;
		return this.first == other.first && this.second==other.second;
	}
}
