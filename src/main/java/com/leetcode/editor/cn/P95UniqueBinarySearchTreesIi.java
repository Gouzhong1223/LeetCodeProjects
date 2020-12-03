package com.leetcode.editor.cn;
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//
//
// 示例：
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 716 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P95UniqueBinarySearchTreesIi {
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
        public List<TreeNode> generateTrees(int n) {
            ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
            dp[0] = new ArrayList<>();
            if (n == 0) {
                return dp[0];
            }
            dp[0].add(null);

            for (int len = 1; len <= n; len++) {
                dp[len] = new ArrayList<>();
                for (int root = 1; root <= len; root++) {
                    int left = root - 1;
                    int right = len - root;
                    for (TreeNode leftTree : dp[left]) {
                        for (TreeNode rightTree : dp[right]) {
                            TreeNode rootTree = new TreeNode(root);
                            rootTree.left = leftTree;
                            rootTree.right = clone(rightTree, root);
                            dp[len].add(rootTree);
                        }
                    }
                }
            }
            return dp[n];
        }

        private TreeNode clone(TreeNode n, int offset) {
            if (n == null) {
                return null;
            }
            TreeNode node = new TreeNode(n.val + offset);
            node.left = clone(n.left, offset);
            node.right = clone(n.right, offset);
            return node;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            List<TreeNode> treeNodes = solution.generateTrees(5);
//            ArrayList<Integer> res = new ArrayList<>();
//            treeNodes.forEach(e -> {
//                PriorityQueue<TreeNode> queue = new PriorityQueue<>();
//                queue.add(e);
//                while (!queue.isEmpty()) {
//                    res.add(queue.poll().val);
//                    if (e.right != null) {
//                        queue.add(e.right);
//                    }
//                    if (e.left != null) {
//                        queue.add(e.left);
//                    }
//                }
//            });
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
