package com.leetcode.editor.cn;
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 389 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P113PathSumIi {
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
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum);
            return res;
        }

        public void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            path.offerLast(root.val);
            sum -= root.val;
            if (sum == 0 && root.left == null && root.right == null) {
                res.add(new LinkedList<>(path));
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            path.pollLast();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
