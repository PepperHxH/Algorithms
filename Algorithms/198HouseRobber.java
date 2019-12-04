class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        int pre = nums[0], tmp = 0, res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res = Math.max(pre, tmp + nums[i]);
            tmp = pre;
            pre = res;
        }
        return res;
    }
}