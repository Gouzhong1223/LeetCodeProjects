package com.leetcode.editor.cn;
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 302 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P103BinaryTreeZigzagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            int deepth = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.pop();
                    if (deepth % 2 == 0) {
                        temp.add(pop.val);
                    } else {
                        temp.add(0, pop.val);
                    }
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                }
                deepth++;
                res.add(temp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
