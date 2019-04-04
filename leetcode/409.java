class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i))!=null) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1); 
            }
        }
        boolean hasOdd = false;
        int res = 0;
        for(Integer i: map.values()) {
            if(i%2 != 0) {
                hasOdd = true;
                res += i-1;
            } else {
                res += i;
            }
        }
        return hasOdd ? res+1 : res;
    }
}