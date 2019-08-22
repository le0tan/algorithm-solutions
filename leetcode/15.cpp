class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        for(int i=0;i<nums.size();i++) {
            if(i!=0) {
                while(i<nums.size() && nums[i] == nums[i-1]) i++;
            }
            int left = i+1;
            int right = nums.size()-1;
            while(left < right) {
                int tar = -nums[i];
                int sum = nums[left] + nums[right];
                if(sum>tar) {
                    right--;
                } else if(sum<tar) {
                    left++;
                } else {
                    // found a triplet
                    vector<int> tri = {nums[i], nums[left], nums[right]};
                    ans.push_back(tri);
                    int ln = nums[left];
                    int rn = nums[right];
                    while(left<nums.size() && nums[left]==ln) left++;
                    while(right<nums.size() && nums[right]==rn) right--;
                }
            }
        }
        return ans;
    }
};