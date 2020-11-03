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
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) {
                    // 因为是从小到大的顺序数组，当中间的数大于 0 的时候，三个数的和始终都大于 0
                    break;
                }
                // 如果当前中间指针和左边的一个指针值相同，则跳过，避免重复结果集
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                // 定义 i j 指针
                int i = k + 1, j = nums.length - 1;

                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    // 三个数之和与 0 作比较
                    if (sum < 0) {
                        // 和小于 0，则说明左指针值太小，这时应该将左边指针向右推进
                        // 判断左指针向右推进以为之后值是否不变，如果不变，则跳过，避免重复结果集
                        while (i < j && nums[i] == nums[++i]) {
                        }
                    } else if (sum > 0) {
                        // 和大于 0.说明右指针值太大，这时应该将右指针向左推进
                        // 判断右指针向左推进以后值是否改变，如果不变继续向左推进
                        while (i < j && nums[j] == nums[--j]) {
                        }
                    } else {
                        // 说明和刚好等于 0 ,加入结果集
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        // 加入结果集之后左指针向右推进到值改变为止
                        while (i < j && nums[i] == nums[++i]) {
                        }
                        // 加入结果集之后右指针向左推进到值改变为止
                        while (i < j && nums[j] == nums[--j]) {
                        }
                    }
                }

            }
            // 返回结果集
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
