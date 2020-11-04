package com.leetcode.editor.cn;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 1096 👎 0

public class P19RemoveNthNodeFromEndOfList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre, end = pre;
            // start 节点先向前移动 N 位
            while (n != 0) {
                start = start.next;
                n--;
            }
            // start 和 end同时移动，直到 start.next 为 null 的时候，此时，start 和 end 相差 N 位，这时的 end 刚好就是倒数第 N 位
            while (start.next != null) {
                start = start.next;
                end = end.next;
            }
            // 将 end 的 next 节点直接删除==>倒数第 N 位的节点被删除
            end.next = end.next.next;
            // 返回 pre.next 的而不返回 head 的原因是因为，head 可能就是被删除的节点
            return pre.next;
        }
//
//        public static void main(String[] args) {
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            listNode.next = listNode1;
//            ListNode listNode2 = new ListNode(3);
//            listNode1.next = listNode2;
//            ListNode listNode3 = new ListNode(4);
//            listNode2.next = listNode3;
//            ListNode listNode4 = new ListNode(5);
//            listNode3.next = listNode4;
//            Solution solution = new Solution();
//            System.out.println(solution.removeNthFromEnd(listNode, 2).val);
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
