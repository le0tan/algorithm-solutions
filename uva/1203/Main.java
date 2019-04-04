import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cmd> l = new ArrayList<>();
        while(true) {
            if(sc.next().equals("#")) break;
            int a = sc.nextInt();
            int b = sc.nextInt();
            l.add(new Cmd(a,b));
        }
        Collections.reverse(l);
        TreeSet<Pair> pairs = new TreeSet<>((a,b) -> {
            return a.time==b.time ? a.query.num - b.query.num : a.time - b.time;
        });
        int k = sc.nextInt();
        int curtime = 0;
        for(Cmd c: l) pairs.add(new Pair(c, c.period));
        for(int i=0;i<k;i++) {
            Pair minpair = pairs.pollFirst();
            System.out.println(minpair.query.num);
            minpair.time += minpair.query.period;
            pairs.add(minpair);
        }
    }
}

class Cmd {
    int num, period;
    public Cmd(int a, int b) {
        num = a; period = b;
    }
}

class Pair {
    Cmd query;
    int time;
    public Pair(Cmd a, int b) {
        query = a; time = b;
    }
}