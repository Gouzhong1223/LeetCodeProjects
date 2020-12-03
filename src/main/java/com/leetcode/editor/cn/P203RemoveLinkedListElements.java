package com.leetcode.editor.cn;
//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 491 👎 0

public class P203RemoveLinkedListElements {
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode a = pre;
            while (a.next != null) {
                if (val == a.next.val) {
                    a.next = a.next.next;
                } else {
                    a = a.next;
                }
            }
            return pre.next;
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
//            ListNode listNode6 = solution.removeElements(listNode, 4);
//            while (listNode6 != null) {
//                System.out.println(listNode6.val);
//                listNode6 = listNode6.next;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
