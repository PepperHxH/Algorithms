class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;
        int n = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    max = Math.max(max, dp[j]+1);
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