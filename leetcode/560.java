class Solution {
  public int subarraySum(int[] nums, int k) {
    int[] partialSum = new int[nums.length];
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    if(nums.length==0) return k==0?1:0;
    partialSum[0] = nums[0];
    ArrayList<Integer> p = new ArrayList<>();
    p.add(0);
    map.put(partialSum[0],p);
    for(int i=1;i<nums.length;i++) {
      partialSum[i] = partialSum[i-1] + nums[i];
      if(map.containsKey(partialSum[i])) {
        map.get(partialSum[i]).add(i);
      } else {
        ArrayList<Integer> t = new ArrayList<>();
        t.add(i);
        map.put(partialSum[i], t);
      }
    }
    int count = 0;
    for(int i=0;i<nums.length;i++) {
      int other = partialSum[i]-k;
      if(other==0) { count++; }
      ArrayList<Integer> choices = map.get(other);
      if(choices == null) continue;
      else {
        for(Integer j: choices) {
          if(i-j>=1) { count++;  }
        }
      }
    }
    return count;
  }
}