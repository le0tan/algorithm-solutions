import java.util.*;

public class Main {
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int iii=0;iii<n;iii++) {
			List<String> str = new ArrayList<>();
			while(true) {
				String s = sc.next();
				if(s.equals("*")) break;
				else str.add(s);
			}
			sc.nextLine();
			HashMap<String, Integer> map = new HashMap<>(str.size());
			for(int i=0;i<str.size();i++)
				map.put(str.get(i), i);
			List<List<Integer>> G = new ArrayList<>();
			for(int i=0;i<str.size();i++)
				G.add(new ArrayList<>());
			for(int i=0;i<str.size();i++) {
				for(int j=i;j<str.size();j++) {
					if(conn(str.get(i), str.get(j))) {
						G.get(i).add(j);
						G.get(j).add(i);
					}
				}
			}
			String line = null;
			while(sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
				String values[] = line.split("\\s+");
				String a = values[0];
				String b = values[1];
				// find shortest from map.get(a) to map.get(b)
				int[] d = new int[str.size()];
				for(int i=0;i<str.size();i++)
					d[i] = Integer.MAX_VALUE;
				d[map.get(a)] = 0;
				Queue<Integer> q = new ArrayDeque<>();
				q.add(map.get(a));
				while(!q.isEmpty()) {
					int cur = q.poll();
					int dis = d[cur];
					for(Integer ii: G.get(cur)) {
						if(d[ii]==Integer.MAX_VALUE) {
							d[ii] = dis + 1;
							q.add(ii);
						}
					}
				}
				System.out.printf("%s %s %d\n", a,b,d[map.get(b)]);
			}
			if(iii<n-1) System.out.println();
		}
	}

	private boolean conn(String a, String b) {
		if(a.length() != b.length()) return false;
		boolean ok = false;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(ok) return false;
				else ok = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
