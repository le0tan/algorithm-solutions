class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		if(nums.length == 0) {
			List<List<Integer>> t = new ArrayList<>();
			t.add(new ArrayList<Integer>());
			return t;
		} else {
			List<List<Integer>> t = subsets(Arrays.copyOfRange(nums, 1, nums.length));
			int ss = t.size();
			for(int i=0;i<ss;i++) {
				List<Integer> temp = new ArrayList<Integer>();
				List<Integer> tt = t.get(i);
				for(int j=0;j<tt.size();j++){
					temp.add(tt.get(j));
				}
				temp.add(nums[0]);
				t.add(temp);
			}
			return t;
		}
	}
}
