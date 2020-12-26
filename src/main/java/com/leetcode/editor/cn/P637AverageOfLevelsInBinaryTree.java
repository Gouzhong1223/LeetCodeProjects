package com.leetcode.editor.cn;
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//
//
// 示例 1：
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//
//
//
// 提示：
//
//
// 节点值的范围在32位有符号整数范围内。
//
// Related Topics 树
// 👍 223 👎 0

import java.util.*;

public class P637AverageOfLevelsInBinaryTree {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                double doubleSum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.pop();
                    doubleSum += pop.val;
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                }
                res.addAll(Collections.singleton(doubleSum / size));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
