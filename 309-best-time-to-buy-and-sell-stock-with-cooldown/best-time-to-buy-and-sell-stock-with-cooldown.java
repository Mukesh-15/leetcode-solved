class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int idx, int buy){
        if(idx >= prices.length){
            return 0;
        }

        if(dp[idx][buy] != null) return dp[idx][buy];

        if(buy == 0){
            dp[idx][buy] = Math.max(-prices[idx] + helper(prices, idx + 1, 1), helper(prices, idx + 1, 0));
            return dp[idx][buy];
        }

        dp[idx][buy] = Math.max(prices[idx] + helper(prices, idx + 2, 0), helper(prices, idx + 1, 1));

        return dp[idx][buy];
    }
}