package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-12-05 13:23
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.leetcode.editor.cn
 * @ProjectName : LeetCodeProjects
 * @Version : 1.0.0
 */
public class InOrderTreeNode {

    public void inOrderTreeNode(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        inOrderTreeNode(root.left, res);
        inOrderTreeNode(root.right, res);
    }

    public static void main(String[] args) {

        List<Integer> res = new ArrayList<>();

        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;

        InOrderTreeNode inOrderTreeNode = new InOrderTreeNode();
        inOrderTreeNode.inOrderTreeNode(treeNode, res);
        for (Integer re : res) {
            System.out.println(re);
        }

    }
}
