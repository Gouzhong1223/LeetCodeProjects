package com.leetcode.editor.cn;
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//.
//返回链表 4->5.
// Related Topics 链表 双指针
// 👍 99 👎 0

public class Offer22LianBiaoZhongDaoShuDiKgeJieDianLcof {
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre, end = pre;
            while (k != 0) {
                start = start.next;
                k--;
            }
            while (start.next != null) {
                start = start.next;
                end = end.next;
            }
            return end.next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(4);
//            ListNode listNode4 = new ListNode(5);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//
//            ListNode kthFromEnd = solution.getKthFromEnd(listNode, 2);
//            System.out.println(kthFromEnd.val);
//
//        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}


