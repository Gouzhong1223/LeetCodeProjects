package com.leetcode.editor.cn;
//给定一个二叉树，在树的最后一行找到最左边的值。
//
// 示例 1:
//
//
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
//
//
//
//
// 示例 2:
//
//
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
//
//
//
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 141 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class P513FindBottomLeftTreeValue {
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
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int result = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.pop();
                    if (i == 0 && pop.left == null && pop.right == null) {
                        result = pop.val;
                    }
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                }
                if (queue.isEmpty()) {
                    return result;
                }
            }
            return -1;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(1);
//            TreeNode treeNode1 = new TreeNode(2);
//            TreeNode treeNode2 = new TreeNode(3);
//            TreeNode treeNode3 = new TreeNode(4);
//            TreeNode treeNode4 = new TreeNode(5);
//            TreeNode treeNode5 = new TreeNode(6);
//            TreeNode treeNode6 = new TreeNode(7);
//
//            treeNode.left = treeNode1;
//            treeNode.right = treeNode2;
//
//            treeNode1.left = treeNode3;
//
//            treeNode2.left = treeNode4;
//            treeNode2.right = treeNode5;
//
//            treeNode4.left = treeNode6;
//            System.out.println(solution.findBottomLeftValue(treeNode));
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
