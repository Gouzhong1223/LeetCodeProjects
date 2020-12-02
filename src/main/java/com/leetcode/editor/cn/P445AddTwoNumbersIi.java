package com.leetcode.editor.cn;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 进阶：
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//
// 示例：
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
//
// Related Topics 链表
// 👍 308 👎 0

import java.util.Stack;

public class P445AddTwoNumbersIi {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            ListNode cur = new ListNode(0);
            ListNode a = cur;

            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            Stack<Integer> res = new Stack<>();
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int x = stack1.isEmpty() ? 0 : stack1.pop();
                int y = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = x + y + carry;
                carry = sum / 10;
                sum = sum % 10;
                res.push(sum);
            }
            // 最后一位进位
            if (carry == 1) {
                a.next = new ListNode(carry);
                a = a.next;
            }
            while (!res.isEmpty()) {
                a.next = new ListNode(res.pop());
                a = a.next;
            }

            return cur.next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(7);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(4);
//            ListNode listNode3 = new ListNode(3);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//
//            ListNode listNode4 = new ListNode(5);
//            ListNode listNode5 = new ListNode(6);
//            ListNode listNode6 = new ListNode(4);
//
//            listNode4.next = listNode5;
//            listNode5.next = listNode6;
//
//            ListNode listNode7 = solution.addTwoNumbers(listNode, listNode4);
//            while (listNode7 != null) {
//                System.out.println(listNode7.val);
//                listNode7 = listNode7.next;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
