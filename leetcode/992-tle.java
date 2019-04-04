class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        // use two pointers
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>(K);
        HashSet<Pair> set = new HashSet<>();
        int count = 0;
        int res = 0;
        boolean ok = true;
        for(int i=0;i<A.length;i++) {
            left=i; right=left; count=0; map=new HashMap<>();
            while(true) {
                if(count == K) {
                    if(map.get(A[right])!=null) {
                        map.put(A[right], map.get(A[right])+1);
                        // System.out.printf("%d %d\n", left,right);
                        // res++;
                        set.add(new Pair(left, right));
                        right++;
                    } else {
                        while(true) {
                            int temp = map.get(A[left]);
                            if(temp == 1) {
                                map.remove(A[left]);
                                left++;
                                break;
                            } else {
                                map.put(A[left], temp-1);
                                left++;
                            }
                        }
                        map.put(A[right], 1);
                        // System.out.printf("%d %d\n", left,right);
                        // res++;
                        set.add(new Pair(left, right));
                        right++;
                    }
                } else {
                    if(map.get(A[right]) != null) {
                        map.put(A[right], map.get(A[right])+1);
                        right++;
                    } else {
                        map.put(A[right], 1);
                        count++;
                        if(count==K) {
                            // res++;
                            // System.out.printf("%d %d\n", left,right);
                            set.add(new Pair(left, right));
                        }
                        right++;
                    }
                }
                if(right>=A.length || left>=A.length || left>right) break;
            }
        }
        return set.size();
    }
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x=x; this.y=y;
        }
        
        @Override
        public int hashCode() {
            return (17*x+23*y)%97;
        }
        
        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            return p.x==this.x && p.y==this.y;
        }
    }
}