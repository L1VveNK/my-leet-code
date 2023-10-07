package 动态规划.q309_买卖股票的最佳时机含冷冻期;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/7 22:36
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size][3];
        dp[0][0] = -prices[0];//持有股票
        dp[0][1] = 0; //未持有股票，不处于冷静期
        dp[0][2] = 0;//未持有股票，处于冷静期
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);//dp[i - 1][2]前一天为冷静期，今天就不是冷静期了
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[size - 1][1], dp[size - 1][2]);
    }

}
