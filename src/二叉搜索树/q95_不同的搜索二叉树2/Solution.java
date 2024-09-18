package 二叉搜索树.q95_不同的搜索二叉树2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenke.li
 * @Description:
 * @date: 2024/9/18 10:41 下午
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftResult = helper(start, i - 1);
            List<TreeNode> rightResult = helper(i + 1, end);

            for (TreeNode leftNode : leftResult) {
                for (TreeNode rightNode : rightResult) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

}