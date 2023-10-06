package 动态规划.q122_买卖股票的最佳时机2;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/6 13:05
 */
public class Solution {

    /**
     * 与question-714一致，不过这里没有手续费
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < size; i++) {
            //第i天未持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //第i天持有股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[size-1][0];
    }

}
