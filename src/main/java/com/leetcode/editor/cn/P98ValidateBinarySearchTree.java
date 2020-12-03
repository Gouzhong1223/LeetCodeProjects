package com.leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 848 👎 0

public class P98ValidateBinarySearchTree {
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
        public boolean isValidBST(TreeNode root) {
            boolean res = true;
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left != null && root.right != null) {
                if (root.left.val >= root.val || root.right.val <= root.val) {
                    return false;
                }
                res = res & isValid(root.left, root.val) & isValid(root.right, root.val);
            }
            if (root.left == null) {
                if (root.right.val <= root.val) {
                    return false;
                }
            }
            if (root.right == null) {
                if (root.left.val >= root.val) {
                    return false;
                }
            }
            return res;
        }

        public boolean isValid(TreeNode root, int father) {
            if (root.left == null && root.right == null) {
                return true;
            }
            boolean res = true;
            if (root.left != null && root.right != null) {
                if (root.left.val >= root.val || root.right.val <= root.val || root.left.val >= father || root.right.val >= father) {
                    return false;
                } else {
                    res = res & isValid(root.left, root.val) & isValid(root.right, root.val);
                }
            } else if (root.left == null) {
                if (root.right.val <= root.val || root.right.val >= father) {
                    res = false;
                } else {
                    res = res & isValid(root.right, root.val);
                }
            } else if (root.right == null) {
                if (root.left.val >= root.val || root.left.val <= father) {
                    res = false;
                } else {
                    res = res & isValid(root.left, root.val);
                }
            }
            return res;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(5);
//            TreeNode treeNode1 = new TreeNode(1);
//            TreeNode treeNode2 = new TreeNode(4);
//            treeNode.left = treeNode1;
//            treeNode.right = treeNode2;
//
//            TreeNode treeNode3 = new TreeNode(3);
//            TreeNode treeNode4 = new TreeNode(6);
//            treeNode2.left = treeNode3;
//            treeNode2.right = treeNode4;
//            TreeNode treeNode = new TreeNode(2);
//            treeNode.left = new TreeNode(1);
//            treeNode.right = new TreeNode(3);
//            TreeNode treeNode = new TreeNode(1);
//            treeNode.right = new TreeNode(1);

//
//            System.out.println(solution.isValidBST(treeNode));
//        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            TreeNode treeNode = new TreeNode(5);
//            TreeNode treeNode1 = new TreeNode(4);
//            TreeNode treeNode2 = new TreeNode(6);
//            treeNode.left = treeNode1;
//            treeNode.right = treeNode2;
//            TreeNode treeNode3 = new TreeNode(3);
//            TreeNode treeNode4 = new TreeNode(7);
//
//            treeNode2.left = treeNode3;
//            treeNode2.right = treeNode4;
//            System.out.println(solution.isValidBST(treeNode));
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
