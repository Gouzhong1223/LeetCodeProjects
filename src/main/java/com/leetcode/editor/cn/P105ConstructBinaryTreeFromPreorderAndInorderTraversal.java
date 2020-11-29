package com.leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 772 👎 0

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inOrderStart, int inOrderEnd) {
            if (preorderStart > preorderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preorderStart]);
            int index = 0;
            // 找到中序数组中 root 节点的位置
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    index = i;
                }
            }

            int leftSize = index - inOrderStart;

            root.left = build(preorder, preorderStart + 1, preorderStart + leftSize,
                    inorder, inOrderStart, index - 1);

            root.right = build(preorder, preorderStart + leftSize + 1, preorderEnd,
                    inorder, index + 1, inOrderEnd);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
