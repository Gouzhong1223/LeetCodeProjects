package com.leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5064 👎 0

public class P2AddTwoNumbers {
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
    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//            ListNode pre = new ListNode(0);
//            ListNode cur = pre;
//
//            int carry = 0;
//
//            while (l1 != null || l2 != null) {
//
//                // 补位
//                int x = l1 == null ? 0 : l1.val;
//                int y = l2 == null ? 0 : l2.val;
//                int sum = x + y + carry;
//                // 进位
//                carry = sum / 10;
//                sum = sum % 10;
//
//                cur.next = new ListNode(sum);
//
//                cur = cur.next;
//                if (l1 != null) {
//                    l1 = l1.next;
//                }
//                if (l2 != null) {
//                    l2 = l2.next;
//                }
//            }
//            if (carry == 1) {
//                cur.next = new ListNode(carry);
//            }
//
//            return pre.next;
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }

        // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        // 输出：7 -> 0 -> 8
        public static void main(String[] args) {
            ListNode listNode = new ListNode(2);
            ListNode listNode1 = new ListNode(4);
            ListNode listNode2 = new ListNode(3);
            ListNode listNode3 = new ListNode(5);
            ListNode listNode4 = new ListNode(6);
            ListNode listNode5 = new ListNode(4);
            listNode.next = listNode1;
            listNode1.next = listNode2;
            listNode3.next = listNode4;
            listNode4.next = listNode5;
            Solution solution = new Solution();

            ListNode listNode6 = solution.addTwoNumbers(listNode, listNode3);

            for (ListNode lNode = listNode6; lNode != null; lNode = lNode.next) {
                System.out.println(lNode.val);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
