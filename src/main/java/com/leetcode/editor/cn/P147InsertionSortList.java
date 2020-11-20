package com.leetcode.editor.cn;
//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
// 插入排序算法：
//
//
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。
//
//
//
//
// 示例 1：
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2：
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表
// 👍 270 👎 0

public class P147InsertionSortList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    // 输入: -1->5->3->4->0
    // 输出: -1->0->3->4->5
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode lastSorted = head, curr = head.next;
            while (curr != null) {
                if (lastSorted.val <= curr.val) {
                    lastSorted = lastSorted.next;
                } else {
                    ListNode prev = dummyHead;
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    lastSorted.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                }
                curr = lastSorted.next;
            }
            return dummyHead.next;
        }


//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(-1);
//            ListNode listNode1 = new ListNode(5);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(4);
//            ListNode listNode4 = new ListNode(0);
//            ListNode listNode5 = new ListNode(2);
//            ListNode listNode6 = new ListNode(6);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            listNode5.next = listNode6;
//
//            ListNode list = solution.insertionSortList(listNode);
//
//            while (list.next != null) {
//                System.out.println("list.val = " + list.val);
//                list = list.next;
//            }
//            System.out.println("list.val = " + list.val);
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
