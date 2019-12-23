class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int s1 = -2;
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]) {
                dp[i] = dp[i-1];
                continue;
            }
            if(s1 == -2) {
                s1 = (nums[i] > nums[i-1]) ? 1 : -1;
                dp[i] = dp[i-1] + 1;
                continue;
            }
            int s2 = (nums[i] > nums[i-1]) ? 1 : -1;
            if(s1 * s2 == -1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
            s1 = s2;
        }
        return dp[n-1];
    }
}

/*
//大神解法
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int up = 1, down = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                up = down + 1;
            } else if(nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
*/