class Solution {
    public int climbStairs(int n) {
        if(n <= 3) return n;
        int cur = 3;
        int pre = 2;
        for(int i = 4; i <= n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }
}