package 动态规划.q714_买卖股票的最佳时机含手续费;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/6 10:45
 */
public class Solution {

    /**
     * dp[i][0] : 表示当天交易结束后，手上未持有股票的最大收益
     * dp[i][1] : 表示当天交易结束后，手上持有股票的最大收益
     * <p>
     * dp[i][0] : 第i天，可能是前一天也没有持有股票dp[i-1][0]；也可能是当天将股票卖出，dp[i-1][1] + price[i] - fee，故dp[i][0] = max (dp[i-1][0], dp[i-1][1] + price[i] - fee)
     * dp[i][1]: 第i天，可能是前一天持有股票dp[i-1][1]；也可能是当天买入股票dp[i-1][0] - price[i], 故 dp[i][1] = max (dp[i-1][1], dp[i-1][0] - price[i])
     * <p>
     * 第一天dp[0][0] = 0,dp[0][1] = -price[0];
     * <p>
     * dp[n][0] 一定是大于 dp[n][1]的，故返回最后一天手上未持有股票的即可
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

}
