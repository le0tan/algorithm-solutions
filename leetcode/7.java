public class Solution {
    public int reverse(int x) {
        boolean neg = x < 0 ? true : false;
        if (neg) x = -x;
        int t = 0;
        while (x > 0) {
            try {
                t = Math.multiplyExact(t, 10);
                t = Math.addExact(t, x % 10);
            } catch (ArithmeticException ex) {
                return 0;
            }
            x = x / 10;
        }
        if (neg) return -t;
        return t;
    }
}