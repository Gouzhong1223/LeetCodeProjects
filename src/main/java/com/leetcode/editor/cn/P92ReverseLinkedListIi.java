package com.leetcode.editor.cn;
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 586 👎 0

import java.util.*;

public class P92ReverseLinkedListIi {
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

        // 后驱节点
        ListNode successor = null;

        public static void main(String[] args) {
            int[] ints = {2, 5, 6, 8, 1, 4, 7, 6};
//            CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>();
//            integers.add(1);
//            Solution solution = new Solution();
//            solution.sort(ints);
//            for (int re : ints) {
//                System.out.println(re);
//            }

            Solution solution = new Solution();
//            String s = "qqqqqqqqqqqqqaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadasda" +
//                    "sdqqqqqdsadlkashjdasddgjdiyduiysuha" +
//                    "sgdfyuUIDFADHUASoyhduashdhashdgasdqqqqqqqqqqqwwwwwwwwww" +
//                    "dasjkdhjkshdhasjkdkasgdashgdhjkagdwwwwwwwweeeeeeeeee" +
//                    "eeeeeerrrrrrrrrrrrrrrrrrttttttttttttyyyyuuuuuxxxxxxx";
//            List<Character> contour = solution.contour(s, 5);
//            for (Character character : contour) {
//                System.out.println(character);
//            }
            solution.bubbleSort(ints);
            for (int anInt : ints) {
                System.out.println(anInt);
            }

            System.out.println(solution.binarySearch(ints, 4));


        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == 1) {
                return reverseN(head, n);
            }
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;

        }

        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;
        }

        public void sort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        public void quickSort(int[] arr, int low, int high) {
            int p, i, j, temp;

            if (low >= high) {
                return;
            }
            // p就是基准数,这里就是每个数组的第一个
            p = arr[low];
            i = low;
            j = high;
            while (i < j) {
                // 右边当发现小于p的值时停止循环
                while (arr[j] >= p && i < j) {
                    j--;
                }

                // 这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

                // 左边当发现大于p的值时停止循环
                while (arr[i] <= p && i < j) {
                    i++;
                }

                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            // 这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
            arr[low] = arr[i];
            arr[i] = p;
            quickSort(arr, low, j - 1);  //对左边快排
            quickSort(arr, j + 1, high); //对右边快排

        }

        public List<Character> contour(String string, int n) {
            HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (characterIntegerHashMap.containsKey(c)) {
                    characterIntegerHashMap.put(c, characterIntegerHashMap.get(c) + 1);
                } else {
                    characterIntegerHashMap.put(c, 1);
                }
            }

            PriorityQueue<Character> characters = new PriorityQueue<>(n, (o1, o2) -> characterIntegerHashMap.get(o2) - characterIntegerHashMap.get(o1));
            for (Character character : characterIntegerHashMap.keySet()) {
                characters.offer(character);
            }
            List<Character> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(characters.poll());
            }
            return res;
        }

        public void bubbleSort(int[] nums) {

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }

        public int binarySearch(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
