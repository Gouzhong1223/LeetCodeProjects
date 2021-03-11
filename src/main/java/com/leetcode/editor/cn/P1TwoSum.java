package com.leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 9311 👎 0

import java.util.HashMap;

public class P1TwoSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int[] twoSum(int[] nums, int target) {

//            HashMap<Integer, Integer> hashMap = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (hashMap.containsKey(nums[i])) {
//                    return new int[]{i, hashMap.get(nums[i])};
//                } else {
//                    hashMap.put(target - nums[i], i);
//                }
//            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(nums[i])) {
                    return new int[]{i, hashMap.get(nums[i])};
                } else {
                    hashMap.put(target - nums[i], i);
                }
            }
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ints = {2, 7, 11, 15};
            int[] ints1 = solution.twoSum(ints, 13);
            for (int i : ints1) {
                System.out.println(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
