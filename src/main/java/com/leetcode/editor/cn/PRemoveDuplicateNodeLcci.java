package com.leetcode.editor.cn;
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 链表
// 👍 80 👎 0

import java.util.HashSet;

public class PRemoveDuplicateNodeLcci {
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
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode dymmNode = new ListNode(-1);
            dymmNode.next = head;
            HashSet<Integer> integers = new HashSet<>();
            while (dymmNode.next != null) {
                if (integers.contains(dymmNode.next.val)) {
                    dymmNode.next = dymmNode.next.next;
                } else {
                    integers.add(dymmNode.next.val);
                    dymmNode = dymmNode.next;
                }
            }
            return head;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(2);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(2);
//            ListNode listNode4 = new ListNode(1);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            ListNode listNode5 = solution.removeDuplicateNodes(listNode);
//            while (listNode5 != null) {
//                System.out.println("listNode.val = " + listNode5.val);
//                listNode5 = listNode5.next;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
