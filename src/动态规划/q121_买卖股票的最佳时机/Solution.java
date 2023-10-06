package 动态规划.q121_买卖股票的最佳时机;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/6 13:13
 */
public class Solution {

    public int maxProfit(int[] prices) {
        //记录最小买入价格
        int[] minInput = new int[prices.length];
        //每天的最大收益
        int[] result = new int[prices.length];
        result[0] = 0;
        minInput[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result[i] = Math.max(result[i - 1], prices[i] - minInput[i - 1]);
            if (prices[i] - minInput[i - 1] < 0) {//找到一个更小的买入价格
                minInput[i] = prices[i];
            } else {
                minInput[i] = minInput[i - 1];
            }
        }
        return result[prices.length - 1];
    }
}
