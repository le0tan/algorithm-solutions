import java.util.*;

public class Solution {
    public static final int N = 255;
    public static int[][] maxd = new int[N][N];
    public static int[][] mind = new int[N][N];
    public static int[][][] d = new int[4][N][N];
    public static char[][] g = new char[N][N];
    public static int[][] w = { {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
    public static Pair[] dist = new Pair[N*N];
    public static int r,c;

    public static boolean ok(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    public static void calc(int dir, int x, int y) {
        d[dir][x][y] = r + c + 1;
        if (g[x][y] == '1')
            d[dir][x][y] = 0;
        else {
            int xx = x + w[dir][0];
            int yy = y + w[dir][1];
            if (ok(xx, y))
                d[dir][x][y] = Math.min(d[dir][x][y], d[dir][xx][y] + 1);
            if (ok(x, yy))
                d[dir][x][y] = Math.min(d[dir][x][y], d[dir][x][yy] + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, j, k, p = 0;
        T = sc.nextInt();
        while (T--!=0) {
            r = sc.nextInt();
            c = sc.nextInt();
            for(i=0;i<r;i++){
                String s = sc.next();
                for(j=0;j<c;j++) {
                    g[i][j]=s.charAt(j);
                }
            }
            for (i = 0; i < r; i++)
                for (j = 0; j < c; j++) {
                    int x = i, y = j;
                    calc(0, x, y);
                    y = c - j - 1;
                    calc(1, x, y);
                    x = r - i - 1;
                    y = j;
                    calc(2, x, y);
                    y = c - j - 1;
                    calc(3, x, y);
                    mind[i][j] = r + c + 1;
                }
            for (i = 0; i < r; i++)
                for (j = 0; j < c; j++) {
                    for (k = 0; k < 4; k++) {
                        mind[i][j] = Math.min(mind[i][j], d[k][i][j]);
                    }
                    dist[i * c + j] = new Pair(mind[i][j], i * c + j);
                }
            // sort(dist, dist + r * c);
            Arrays.sort(dist, 0,r*c, (x,y)-> {
                return x.first==y.first?x.second==y.second?0:x.second-y.second:x.first-y.first;
            });
            // Arrays.sort(a, fromIndex, toIndex, c);
            for(i=0;i<maxd.length;i++) 
                for(j=0;j<maxd[i].length;j++)
                    maxd[i][j]=-1;
            // memset(maxd, -1, sizeof(maxd));
            int ans = dist[r * c - 1].first;
            int m = r * c - 1;
            for (i = ans - 1; i >= 0; i--) {
                for (; m >= 0 && dist[m].first > i; m--) {
                    int x = dist[m].second / c;
                    int y = dist[m].second % c;
                    for (j = 0; j < r; j++)
                        for (k = 0; k < c; k++) {
                            maxd[j][k] = Math.max(maxd[j][k], Math.abs(j - x) + Math.abs(k - y));
                        }
                }
                boolean f = false;
                for (j = 0; j < r; j++) {
                    for (k = 0; k < c; k++) {
                        if (maxd[j][k] <= i) {
                            ans = i;
                            f = true;
                            break;
                        }
                    }
                    if (f)
                        break;
                }
                if (!f)
                    break;
            }
            System.out.printf("Case #%d: %d\n", ++p, ans);
        }
    }

    static class Pair {
        int first, second;

        public Pair(int x, int y) {
            first = x;
            second = y;
        }
    }
}