package com.leetcode.editor.cn;
//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 👍 263 👎 0

public class P404SumOfLeftLeaves {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        int res = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            helper(root);
            return res;
        }

        public void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null || root.right != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                }
                helper(root.left);
                helper(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
