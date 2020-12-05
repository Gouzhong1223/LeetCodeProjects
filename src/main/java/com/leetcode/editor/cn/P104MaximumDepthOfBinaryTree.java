package com.leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 👍 751 👎 0

public class P104MaximumDepthOfBinaryTree {
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
        public int maxDepth(TreeNode root) {
            return dfs(root);
        }
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int max = 1;
            if (root.left == null && root.right == null) {
                return max;
            }
            if (root.left != null || root.right != null) {
                max = Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
