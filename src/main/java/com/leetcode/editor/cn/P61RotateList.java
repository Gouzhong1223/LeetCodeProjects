package com.leetcode.editor.cn;
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
// 👍 366 👎 0

public class P61RotateList {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode oldTail = head;
            int n;
            for(n = 1; oldTail.next != null; n++) {
                oldTail = oldTail.next;
            }
            oldTail.next = head;
            ListNode newTail = head;
            for (int i = 0; i < n - k % n - 1; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            newTail.next = null;
            return newHead;


//            // 统计节点个数
//            int num = 1;
//            ListNode cur = head;
//            while (cur.next != null) {
//                cur = cur.next;
//                num++;
//            }
//            // 记录尾节点
//            ListNode tail = cur;
//
//            // 是否会变回原位置
//            int count = k % num;
//            if (count == 0) {
//                return head;
//            }
//
//            // 找到需要移动的节点中最后一个
//            count = num - count;
//            cur = head;
//            while (count > 1) {
//                cur = cur.next;
//                count--;
//            }
//
//            // 重构链表
//            ListNode next = cur.next;
//            cur.next = null;
//            tail.next = head;
//            return next;
        }

//        /**
//         * 将链表进行一次旋转
//         *
//         * @param head 链表
//         */
//        public void rotate(ListNode head) {
//            ListNode last = head;
//            while (last.next != null && last.next.next != null) {
//                ListNode n = last.next;
//                n.next = null;
//                last = last.next.next;
//            }
//            last.next = head;
//        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            ListNode listNode = new ListNode(0);
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(2);
            ListNode listNode3 = new ListNode(3);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            ListNode listNode4 = solution.rotateRight(listNode, 1);
            while (listNode4 != null) {
                System.out.println(listNode4.val);
                listNode4 = listNode4.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
