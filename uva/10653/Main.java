import java.util.*;

public class Main {


  private void run() {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int r=sc.nextInt();
      int c=sc.nextInt();
      if(r==0&&c==0) break;
      int br = sc.nextInt();
      boolean[][] map = new boolean[r][c];
      for(int i=0;i<br;i++) {
        int k = sc.nextInt();
        int o = sc.nextInt();
        for(int j=0;j<o;j++) map[k][sc.nextInt()] = true;
      }
      Point start = new Point(sc.nextInt(), sc.nextInt());
      Point end = new Point(sc.nextInt(), sc.nextInt());
      int[][] dist = new int[r][c];
      for(int i=0;i<r;i++) for(int j=0;j<c;j++) dist[i][j] = -1;
      dist[start.x][start.y] = 0;
      Queue<Point> q = new ArrayDeque<>();
      q.add(start);
      while(!q.isEmpty()) {
        Point cur = q.poll();
        int dis = dist[cur.x][cur.y];
        int[] cx = {1,-1,0,0};
        int[] cy = {0,0,1,-1};
        for(int i=0;i<4;i++) {
          int xx = cur.x+cx[i];
          int yy = cur.y+cy[i];
          if(xx>=0 && xx<r && yy>=0 && yy<c && !map[xx][yy]) {
            if(dist[xx][yy]==-1) {
              dist[xx][yy] = dis+1;
              q.add(new Point(xx,yy));
            }
          }
        }
      }
      System.out.println(dist[end.x][end.y]);
    }

  }

  public static void main(String[] args) {
    Main m = new Main();
    m.run();
  }
}

class Point {
  int x,y;
  public Point(int a,int b) {
    x=a; y=b;
  }
}
