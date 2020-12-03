package com.leetcode.editor.cn;
//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
//
//
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
//
//
//
//
//
// 示例 1：
//
// 输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
//
// 示例 2：
//
// 输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
//
//
//
//
// 提示：
//
//
// 链表至少包含两个节点。
// 链表中所有节点的值都是唯一的。
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
// 不要从你的函数中返回任何结果。
//
// Related Topics 链表
// 👍 804 👎 0

public class P237DeleteNodeInALinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
     class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(2);
//            ListNode listNode1 = new ListNode(4);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(5);
//            ListNode listNode4 = new ListNode(6);
//            ListNode listNode5 = new ListNode(4);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            solution.deleteNode(listNode);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
