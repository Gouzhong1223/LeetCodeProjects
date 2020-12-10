package com.leetcode.editor.cn;
//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
//
//
// 示例 1：
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
//
//
// 示例 2：
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42
// Related Topics 树 深度优先搜索
// 👍 781 👎 0

public class P124BinaryTreeMaximumPathSum {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return maxSum;
        }

        public int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = Math.max(helper(root.left), 0);
            int rightMax = Math.max(helper(root.right), 0);
            int newPrice = root.val + leftMax + rightMax;
            maxSum = Math.max(newPrice, maxSum);
            return root.val + Math.max(leftMax, rightMax);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
