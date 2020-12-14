package com.leetcode.editor.cn;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1361 👎 0

public class P206ReverseLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(1);
            ListNode listNode1 = new ListNode(2);
            ListNode listNode2 = new ListNode(3);
            ListNode listNode3 = new ListNode(4);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            ListNode listNode4 = solution.reverseList(listNode);
            while (listNode4 != null) {
                System.out.println(listNode4.val);
                listNode4 = listNode4.next;
            }
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode lastNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return lastNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
