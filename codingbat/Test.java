/**
 * Test
 */
public class Test {
    public static String stringTimes(String str, int n) {
        String res = new String();
        for(int i=0;i<n;i++){
          res += str;
        }
        return res;
    }
    
    public static String frontTimes(String str, int n) {
        if(str.length() >= 3) str = str.substring(0, 3);
        String res = new String();
        for(int i=0;i<n;i++) {
            res += str;
        }
        return res;
    }

    public static boolean doubleX(String str) {
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == 'x') {
                return i+1 < str.length() && str.charAt(i+1) == 'x';
            }
        }
        return false;
    }

    public static int countXX(String str) {
        int count = 0;
        for(int i=1;i<str.length();i++) {
            if(str.charAt(i) == 'x' && str.charAt(i-1) == 'x') {
                count++;
            }
        }
        return count;
    }
    
    public static int countClumps(int[] nums) {
        if(nums.length==0) return 0;
        int cnt = 0;
        int lastVal = nums[0];
        boolean ok = false;
        for(int i=1;i<nums.length;i++) {
          if(nums[i]==lastVal) {
            if(!ok) {
              ok = true;
              cnt++;
            }
          } else {
            ok = false;
            lastVal = nums[i];
          }
        }
        return cnt;
      }
      
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(countClumps(arr));
    }
}