class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ans = nums[0]+nums[1]+nums[2];
        int closest = abs(ans-target);
        for(int i=0;i<nums.size();i++) {
            int l = i+1;
            int r = nums.size()-1;
            while(l<r) {
                int s = nums[l]+nums[r]+nums[i];
                if(abs(s-target)<closest) {
                    ans = s;
                    closest = abs(s-target);
                }
                if(s<target)
                    l++;
                else if(s>target)
                    r--;
                else return target;
            }
        }
        return ans;
    }
};