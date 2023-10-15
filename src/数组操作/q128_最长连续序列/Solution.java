package 数组操作.q128_最长连续序列;

import java.util.Arrays;

/**
 * @author: wenke.li
 * @Description: 不想了，直接排序，结果还超过了89%
 * @data: 2023/10/15 21:21
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int currentGap = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                currentGap++;
            } else {
                max = Math.max(max, currentGap);
                currentGap = 1;
            }
        }
        return Math.max(max, currentGap);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 1};
        Solution solution = new Solution();
        int i = solution.longestConsecutive(nums);
        System.out.println(i);
    }

}
