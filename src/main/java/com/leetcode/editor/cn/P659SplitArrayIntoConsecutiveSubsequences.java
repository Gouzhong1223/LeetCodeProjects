package com.leetcode.editor.cn;
//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3
//3, 4, 5
//
//
//
//
// 示例 2：
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3, 4, 5
//3, 4, 5
//
//
//
//
// 示例 3：
//
// 输入: [1,2,3,4,4,5]
//输出: False
//
//
//
//
// 提示：
//
//
// 输入的数组长度范围为 [1, 10000]
//
//
//
// Related Topics 堆 贪心算法
// 👍 155 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P659SplitArrayIntoConsecutiveSubsequences {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public boolean isPossible(int[] nums) {
//            HashMap<Integer, PriorityQueue<Integer>> hashMap = new HashMap<>();
//            for (int num : nums) {
//                if (!hashMap.containsKey(num)) {
//                    hashMap.put(num, new PriorityQueue<>());
//                }
//                if (hashMap.containsKey(num - 1)) {
//                    Integer length = hashMap.get(num - 1).poll();
//                    if (hashMap.get(num - 1).isEmpty()) {
//                        hashMap.remove(num - 1);
//                    }
//                    hashMap.get(num).offer(length + 1);
//                } else {
//                    hashMap.get(num).offer(1);
//                }
//            }
//            Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = hashMap.entrySet();
//
//            for (Map.Entry<Integer, PriorityQueue<Integer>> integerPriorityQueueEntry : entrySet) {
//                PriorityQueue<Integer> value = integerPriorityQueueEntry.getValue();
//                if (value.peek() < 3) {
//                    return false;
//                }
//            }

            HashMap<Integer, Integer> integerHashMap = new HashMap<>();
            HashMap<Integer, Integer> endPoint = new HashMap<>();
            for (int num : nums) {
                if (integerHashMap.containsKey(num)) {
                    integerHashMap.put(num, integerHashMap.get(num) + 1);
                } else {
                    integerHashMap.put(num, 1);
                }
            }

            for (int num : nums) {

            }

            return true;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ints = {1, 2, 3, 3, 4, 4, 5, 5};
            System.out.println(solution.isPossible(ints));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
