import java.util.*;

public class Main {

	int cnt;
	int m;
	int n;

	private void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			m = sc.nextInt();
			n = sc.nextInt();
			char[][] chars = new char[m][n];
			boolean[][] map = new boolean[m][n];
			for(int i=0;i<m;i++) {
				String s = sc.next();
				for(int j=0;j<n;j++) {
					chars[i][j] = s.charAt(j);
				}
			}
			boolean[][] vis = new boolean[m][n];
			int x = sc.nextInt();
			int y = sc.nextInt();
			int land = chars[x][y];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(chars[i][j]==land) map[i][j]=true;
				}
			}
			dfs(x,y,vis,map);
			int res = 0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] && !vis[i][j]) {
						cnt = 0;
						dfs(i,j,vis,map);
						res = Math.max(res, cnt);
					}
				}
			}
			System.out.println(res);
			if(!sc.hasNext()) break;
			else {
				sc.nextLine(); sc.nextLine();
			}
		}
	}

	private void dfs(int x, int y, boolean[][] vis, boolean[][] map) {
		if(!map[x][y] || vis[x][y]) return;
		vis[x][y] = true;
		cnt++;
		int[] cx = {1, -1, 0, 0};
		int[] cy = {0, 0, 1, -1};
		for(int i=0;i<4;i++) {
			int cxx = x+cx[i];
			if(cxx>=m || cxx<0) continue;
			int cyy = (y+cy[i]+n)%n;
			dfs(cxx, cyy, vis, map);
		}
	}


	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
