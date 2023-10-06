package 动态规划.q53_最大子数组和;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/6 14:30
 */
public class Solution {

    /**
     * dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        for (int i = 1; i < size; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
