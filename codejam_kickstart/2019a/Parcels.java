import java.util.*;

public class Parcels {
    
    public static int max_dist(int r, int c, 
                        int[][] g, List<Point> stations, Point addi) {
        int res = -1;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(g[i][j] == 0) {
                    int mindist = Math.abs(i-addi.x)+Math.abs(j-addi.y);
                    for(int k=0;k<stations.size();k++) {
                        int dist = Math.abs(i-stations.get(k).x) +
                                Math.abs(j-stations.get(k).y);
                        mindist = Math.min(mindist,dist);
                    }
                    // System.out.printf("mindist of (%d,%d) is %d\n", i,j,mindist);
                    if(res==-1) res = mindist;
                    else res = Math.max(mindist, res);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++) {
            int r=sc.nextInt();
            int c=sc.nextInt();
            int[][] g = new int[r][c];
            List<Point> stations = new ArrayList<>();
            for(int j=0;j<r;j++) {
            	String row = sc.next();
                for(int k=0;k<c;k++) {
                    g[j][k] = Integer.parseInt(row.substring(k,k+1));
                    if(g[j][k]==1) stations.add(new Point(j,k));
                }
            }
            int min = -1;
            for(int j=0;j<r;j++) {
                for(int k=0;k<c;k++) {
                    if(g[j][k]==0) {
                        int kk =max_dist(r,c,g,stations,new Point(j,k));
                        if(min==-1) min=kk;
                        else min=Math.min(kk,min);
                    }
                }
            }
            System.out.printf("Case #%d: %d\n", i+1, min==-1?0:min);
        }
    }
    
    static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x=x;this.y=y;
        }
    }
}