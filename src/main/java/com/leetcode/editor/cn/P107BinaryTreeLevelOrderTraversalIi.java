package com.leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 364 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P107BinaryTreeLevelOrderTraversalIi {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            if (root == null) {
                return res;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> integers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.pop();
                    integers.add(pop.val);
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                }
                res.add(0, integers);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
