public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int idx = 0;
        int maxlen = 0;
//        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (m.get(cur) == null) {
                m.put(cur, i);
                maxlen = Math.max(maxlen, i - idx + 1);
            } else {
                int last = m.get(cur);
                while (last >= idx) {
                    idx++;
                }
                maxlen = Math.max(maxlen, i - idx + 1);
                m.replace(cur, i);
            }
        }
        return maxlen;
    }
}