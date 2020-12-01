package com.leetcode.editor.cn;
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
//
//
// 示例:
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
// Related Topics 链表 双指针
// 👍 282 👎 0

public class P86PartitionList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
      Definition for singly-linked list.
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      }
     */

    /**
     * 思路：将链表拆分成两部分，然后再拼接
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode before = new ListNode(0);
            ListNode a = before;
            ListNode after = new ListNode(0);
            ListNode b = after;
            while (head != null) {
                if (x > head.val) {
                    a.next = head;
                    a = a.next;
                } else {
                    b.next = head;
                    b = b.next;
                }
                head = head.next;
            }
            b.next = null;
            a.next = after.next;
            return before.next;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            ListNode listNode = new ListNode(1);
//            ListNode listNode1 = new ListNode(4);
//            ListNode listNode2 = new ListNode(3);
//            ListNode listNode3 = new ListNode(2);
//            ListNode listNode4 = new ListNode(5);
//            ListNode listNode5 = new ListNode(2);
//            listNode.next = listNode1;
//            listNode1.next = listNode2;
//            listNode2.next = listNode3;
//            listNode3.next = listNode4;
//            listNode4.next = listNode5;
//            ListNode partition = solution.partition(listNode, 3);
//            while (partition != null) {
//                System.out.println(partition.val);
//                partition = partition.next;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
