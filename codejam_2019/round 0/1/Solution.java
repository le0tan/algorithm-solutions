import java.util.*;

public class Solution {
    
    static private boolean haveFour(long a) {
        while(a>0) {
            long t = a%(long)10;
            if(t==(long)4) return true;
            a = a/(long)10;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++) {
            String s = sc.next();
            String res = "";
            String temp = "";
            int pos=-1;
            for(int j=0;j<s.length();j++) {
                if(s.charAt(j)=='4') {
                    pos=j;
                    break;
                } else {
                    temp += s.charAt(j);
                }
            }
            for(int j=pos;j<s.length();j++) {
                res += s.charAt(j)=='4' ? '1' : '0';
                temp += s.charAt(j)=='4' ? '3' : s.charAt(j);
            }
            System.out.printf("Case #%d: %s %s\n", i, temp, res);
        }
    }
}
