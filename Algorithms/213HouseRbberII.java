class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int cur = 0, pre = 0, res1, res2;
        for(int i = 0; i < n-1; i++) {
            int sum = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = sum;
        }
        res1 = cur;
        cur = 0;
        pre = 0;
        for(int i = 1; i < n; i++) {
            int sum = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = sum;
        }
        res2 = cur;
        return Math.max(res1, res2);
    }
}