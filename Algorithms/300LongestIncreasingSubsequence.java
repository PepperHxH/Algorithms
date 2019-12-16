//动态规划 O(n2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/*
//贪心算法+二分查找 O(nlogn)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for(int x : nums) {
            int i = 0, j = size;
            while(i != j) {
                int mid = (i + j) / 2;
                if(tails[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = x;
            if(i == size) ++size;
        }
        return size;
    }
}

*/