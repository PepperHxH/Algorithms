class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int buy = prices[0], res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > buy) {
                res = Math.max(res, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return res;
    }
}
