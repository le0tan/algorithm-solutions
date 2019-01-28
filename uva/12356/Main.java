import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int b = sc.nextInt();
		int prev[] = new int[100100];
		int next[] = new int[100100];
		int l;
		int r;
		while(s!=0 || b !=0) {
			for(int i=1;i<=s;i++) {
				prev[i] = i-1;
				next[i] = i+1;
			}
			prev[1] = -1;
			next[s] = -1;
			for(int i=0;i<b;i++) {
				l = sc.nextInt();
				r = sc.nextInt();
				if(prev[l] != -1) {
					next[prev[l]] = next[r];
					System.out.print(prev[l]);
					System.out.print(" ");
				} else {
					System.out.print("* ");
				}
				if(next[r] != -1) {
					prev[next[r]] = prev[l];
					System.out.print(next[r]);
				} else {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println("-");
			s = sc.nextInt();
			b = sc.nextInt();
		}
	}
}
