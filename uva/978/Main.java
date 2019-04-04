import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int b = sc.nextInt();
            int sg = sc.nextInt();
            int sb = sc.nextInt();
            PriorityQueue<Integer> green = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> blue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<sg;i++) green.add(sc.nextInt());
            for(int i=0;i<sb;i++) blue.add(sc.nextInt());
            boolean ok = true;
            while(true) {
                List<Integer> rg = new ArrayList<>();
                List<Integer> rb = new ArrayList<>();
                for(int i=0;i<b;i++) {
                    if(blue.isEmpty() || green.isEmpty()) break;
                    int x = green.poll();
                    int y = blue.poll();
                    if(x==y) continue;
                    else if(x>y) {
                        rg.add(x-y);
                    } else {
                        rb.add(y-x);
                    }
                }
                for(Integer i: rg) green.add(i);
                for(Integer i: rb) blue.add(i);
                if(green.isEmpty() || blue.isEmpty()) break;
            }
            if(green.isEmpty() && blue.isEmpty()) System.out.println("green and blue died");
            else if(!green.isEmpty()) {
                System.out.println("green wins");
                while(!green.isEmpty()) System.out.println(green.poll());
            } else {
                System.out.println("blue wins");
                while(!blue.isEmpty()) System.out.println(blue.poll());
            }
            if(T!=0) System.out.println();
        }
    }
}

class Person {
    int idx, power;
    public Person(int a, int b) {
        idx = a; power = b;
    }
}