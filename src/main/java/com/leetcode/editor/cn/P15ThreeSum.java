package com.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
// 👍 2663 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // 1 2 3 4 5 6 7
            Arrays.sort(nums);
            for (int k = 0; k < nums.length - 1; k++) {
                if (nums[k] > 0) {
                    break;
                }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) {
                        }
                    } else if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) {
                        }
                    } else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[j] == nums[--j]) {
                        }
                        while (i < j && nums[i] == nums[++i]) {
                        }
                    }
                }
            }
            return res;
        }

//        /**
//         * 三数之和
//         *
//         * @param nums 数组
//         * @return List<List < Integer>>
//         */
//        private List<List<Integer>> threeSumTarget(int[] nums) {
//            Arrays.sort(nums);
//            List<List<Integer>> res = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                List<Integer> list = twoSumTarget(nums, i + 1, -nums[i]);
//                if (list.size() != 0) {
//                    list.add(nums[i]);
//                    res.add(list);
//                }
//                // 跳过第一个数字重复的情况，否则会出现重复结果
//                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
//                    i++;
//                }
//            }
//            return res;
//        }

//        /**
//         * 两数之和
//         *
//         * @param nums   数组
//         * @param target 目标值
//         * @return List<Integer>
//         */
//        private List<Integer> twoSumTarget(int[] nums, int start, int target) {
//            int left = start, right = nums.length - 1;
//            List<Integer> res = new ArrayList<>();
//            while (left < right) {
//                int l = nums[left];
//                int r = nums[right];
//                int num = l + r;
//                if (num < target) {
//                    left++;
//                } else if (num > target) {
//                    right--;
//                } else {
//                    res.add(l);
//                    res.add(r);
//                    while (left < right && nums[left] == l) {
//                        left++;
//                    }
//                    while (left < right && nums[right] == r) {
//                        right--;
//                    }
//                }
//            }
//            return res;
//        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] ints = {-1, 0, 1, 2, -1, -4};
//            List<List<Integer>> lists = solution.threeSum(ints);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


