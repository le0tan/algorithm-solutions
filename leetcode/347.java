class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for(Map.Entry<Integer,Integer> i: map.entrySet()) {
            pq.add(new Pair(i.getKey(), i.getValue()));
        }
        for(int i=0;i<k;i++) {
            res.add(pq.poll().key);
        }
        return res;
    }
    
    class Pair implements Comparable<Pair>{
        int key, value;
        Pair(int a, int b) {
            key=a; value=b;
        }
        @Override
        public int compareTo(Pair p) {
            return p.value - this.value;
        }
    }
}