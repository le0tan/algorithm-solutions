import java.util.*;

public class Main {

  static int INF = 1000000000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int kase = 0;
    while(kase++ < N) {
      int n = sc.nextInt(), m = sc.nextInt();
      int S = sc.nextInt(), T = sc.nextInt();
      List<List<Edge>> g = new ArrayList<>();
      for(int i=0;i<n;i++)
        g.add(new ArrayList<>());
      for(int i=0;i<m;i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        g.get(a).add(new Edge(b,w));
        g.get(b).add(new Edge(a,w));
      }
      int[] dist = new int[n];
      for(int i=0;i<n;i++)
        dist[i] = INF;
      dist[S] = 0;
      dijkstra(g, dist, S);
      System.out.println("Case #"+kase+": "+(dist[T]==INF?"unreachable":dist[T]));
    }
  }

  private static void dijkstra(List<List<Edge>> g, int[] dist, int S) {
    PriorityQueue<Node> q = new PriorityQueue<>( (x,y) -> x.dis - y.dis );
    q.add(new Node(S, 0));
    boolean[] vis = new boolean[dist.length];
    while(!q.isEmpty()) {
      Node cur = q.poll();
      if(cur.dis != dist[cur.index]) continue;
      vis[cur.index] = true;
      for(Edge e: g.get(cur.index)) {
        if(!vis[e.to]) {
          if(dist[cur.index]+e.weight<dist[e.to]) {
            dist[e.to] = dist[cur.index]+e.weight;
            q.add(new Node(e.to, dist[e.to]));
          }
        }
      }
    }
  }
}

class Edge {
  int to, weight;
  public Edge(int a, int b) {
    to = a; weight = b;
  }
}

class Node {
  int index, dis;
  public Node(int a, int b) {
    index = a; dis = b;
  }
}
