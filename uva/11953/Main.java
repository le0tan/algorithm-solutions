import java.util.*;


public class Main {

	int n;

	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int kase = 0;
		while(T-- > 0) {
			kase++;
			n = sc.nextInt();
			char[][] g = new char[n][n];
			for(int i=0;i<n;i++) {
				String s = sc.next();
				for(int j=0;j<n;j++) {
					g[i][j] = s.charAt(j);
				}
			}
		
			boolean[][] vis = new boolean[n][n];
			int cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(g[i][j]=='x'&&!vis[i][j]) {
						dfs(i,j,g,vis);
						cnt++;
					}
				}
			}

			System.out.printf("Case %d: %d\n", kase, cnt);
		
		}
	}

	private void dfs(int x, int y, char[][] g, boolean[][] vis) {
		// hori means goes horizontally <-> dir
		if(vis[x][y] || g[x][y]=='.') return;
		vis[x][y] = true;
		if(y+1<n) dfs(x,y+1,g,vis);
		if(y-1>=0) dfs(x,y-1,g,vis);
		if(x+1<n) dfs(x+1,y,g,vis);
		if(x-1>=0) dfs(x-1,y,g,vis);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
