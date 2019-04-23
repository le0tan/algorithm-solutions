import java.util.*;

public class Solution {

  ArrayList<Pair> res = new ArrayList<>();
  int r;
  int c;

  private void run() {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int kase=1;kase<=T;kase++) {
      r = sc.nextInt();
      c = sc.nextInt();
      boolean[][] vis = new boolean[r][c];
      boolean ok = false;
      res = new ArrayList<>();
      for(int i=0;i<r;i++) {
        if(ok) break;
        for(int j=0;j<c;j++) {
          vis = new boolean[r][c];
          if(dfs(i,j,vis)) {
            System.out.println("Case #"+kase+": POSSIBLE");
            for(Pair p: res) {
              System.out.printf("%d %d\n", p.x+1, p.y+1);
            }
            ok = true;
            break;
          }
        }
      }
      if(!ok) {
        System.out.println("Case #"+kase+": IMPOSSIBLE");
      }
    }
  }

  private boolean dfs(int x, int y, boolean[][] vis) {
    // System.out.printf("dfs(%d %d)\n",x,y);
    boolean ok = true;
    vis[x][y] = true;
    int start_idx = res.size();
    res.add(new Pair(x,y));
    for(int i=0;i<r;i++) {
      if(i==x) continue;
      for(int j=0;j<c;j++) {
        // System.out.println("asd");
        if(j==y) continue;
        if(Math.abs(x-i)==Math.abs(y-j)) continue;
        if(vis[i][j]) continue;
        ok = false;
        if(dfs(i,j,vis)) {
          // System.out.printf("A(%d,%d) returns true\n", x,y);
          return true;
        }
        vis[i][j] = false;
        res.subList(start_idx+1, res.size()).clear();
      }
    }
    if(ok) {
      for(int i=0;i<r;i++) {
        for(int j=0;j<c;j++) {
          if(!vis[i][j]) return false;
        }
      }
      // System.out.printf("B(%d,%d) returns true\n", x,y);
      return true;
    }
    vis[x][y] = false;
    // res.subList(start_idx, res.size()).clear();
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.run();
  }
}

class Pair {
  int x,y;
  public Pair(int a,int b) {
    x=a; y=b;
  }
}