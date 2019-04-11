import java.util.*;

public class Main {

  final int INF = 1000000000;

	private void run() {
		Scanner sc = new Scanner(System.in);
    int kase = sc.nextInt();
    while(kase-- > 0) {
      int n=sc.nextInt(), E=sc.nextInt()-1, T=sc.nextInt();
      int m = sc.nextInt();
      List<List<Edge>> g = new ArrayList<>();
      for(int i=0;i<n;i++) {
        g.add(new ArrayList<>());
      }
      for(int i=0;i<m;i++) {
        int a=sc.nextInt()-1,b=sc.nextInt()-1,c=sc.nextInt();
        g.get(b).add(new Edge(a,c)); // reverse the graph
      }
      int[] dist = new int[n];
      for(int i=0;i<n;i++)
        dist[i] = INF;
      dist[E] = 0;
      dijkstra(g, dist, E);
      int cnt = 0;
      for(int i=0;i<n;i++)
        if(dist[i] <= T) cnt++;
      System.out.println(cnt);
      if(kase>=1) System.out.println();
    }
	}

  private void dijkstra(List<List<Edge>> g, int[] dist, int S) {
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

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
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