package com.leetcode.editor.cn;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 406 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P111MinimumDepthOfBinaryTree {
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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // root 本身就算一个节点
            int depth = 1;
            // 构造队列
            Queue<TreeNode> queue = new LinkedList<>();
            // 将 root 节点添加到队列
            queue.offer(root);

            // BFS 搜索
            while (!queue.isEmpty()) {
                // 获取当前队列的节点个数
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 从队列中取出一个节点
                    TreeNode poll = queue.poll();
                    // 判断取出的节点是否是叶子节点
                    if (poll.left == null && poll.right == null) {
                        return depth;
                    }
                    // 不是叶子节点的话就把左右节点添加到队列中
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                depth++;
            }
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
            integerIntegerHashMap.put(1, 1);
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
