package com.leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 483 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P145BinaryTreePostorderTraversal {
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

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            // 深度优先 DFS
            TreeNode prev = null;
            while (!stack.isEmpty() || root != null) {
                // 先将根节点和所有的左节点都压入栈底
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }

            }
            return res;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(0);
//            TreeNode treeNode1 = new TreeNode(1);
//            TreeNode treeNode2 = new TreeNode(2);
//
//            TreeNode treeNode3 = new TreeNode(3);
//            TreeNode treeNode4 = new TreeNode(4);
//            TreeNode treeNode5 = new TreeNode(5);
//            TreeNode treeNode6 = new TreeNode(6);
//            TreeNode treeNode7 = new TreeNode(7);
//            TreeNode treeNode8 = new TreeNode(8);
//
//            treeNode.left = treeNode1;
//            treeNode.right = treeNode2;
//
//            treeNode1.left = treeNode3;
//            treeNode1.right = treeNode4;
//
//            treeNode2.left = treeNode5;
//            treeNode2.right = treeNode6;
//
//            treeNode3.left = treeNode7;
//            treeNode3.right = treeNode8;
//            List<Integer> integers = solution.postorderTraversal(treeNode);
//
//            integers.forEach(System.out::println);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
