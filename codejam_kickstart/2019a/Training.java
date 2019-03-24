import java.util.*;
class Training {
    public static int calc(int n,int p,int[] s) {
        Arrays.sort(s);
        int[] a = new int[s.length+1];
        int[] b = new int[s.length+1];
        int[] scores = new int[s.length+1];
        scores[0] = -1;
        for(int i=0;i<s.length;i++) {
            scores[i+1] = s[i];
        }
        b[0] = 0;
        for(int i=1;i<=s.length;i++) {
            a[i] = s[s.length-1] - scores[i];
            b[i] = b[i-1] + a[i];
        }
        int min = -1;
        for(int i=1;i<=s.length-p+1;i++) {
            int cur = (b[i+p-1]-b[i-1]) - a[i+p-1] * p;
            if(min==-1) min = cur;
            else min = Math.min(min, cur);
        }
        return min;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] s = new int[n];
			for(int j=0;j<n;j++)
				s[j] = sc.nextInt();
			System.out.printf("Case #%d: %d\n", i+1, calc(n,p,s));
		}
	}
}
