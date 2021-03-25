package com.leetcode.editor.cn;
//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,2]
//输出："210"
//
// 示例 2：
//
//
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出："1"
//
//
// 示例 4：
//
//
//输入：nums = [10]
//输出："10"
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 排序
// 👍 438 👎 0


import java.util.Arrays;

public class P179LargestNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strings, (x, y) -> (y + x).compareTo(x + y));
            StringBuilder builder = new StringBuilder();
            for (String s : strings) {
                builder.append(s);
            }
            String res = builder.toString();
            if (res.charAt(0) == '0') {
                return "0";
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
