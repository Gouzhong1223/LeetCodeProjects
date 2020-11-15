package com.leetcode.editor.cn;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 数学 二分查找
// 👍 453 👎 0

public class P29DivideTwoIntegers {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int divide(int dividend, int divisor) {
            int res = 0;
            if (dividend == 0) {
                return res;
            }
            if ((dividend > 0 && divisor > 0)) {
                // 7/3
                while (dividend >= divisor) {
                    dividend -= divisor;
                    res++;
                }
                return res;
            } else if (dividend > 0 && divisor < 0) {
                // 7/-3
                while (-dividend <= divisor) {
                    dividend += divisor;
                    res++;
                }
                return -res;

            } else if (dividend < 0 && divisor > 0) {
                // -7/3
                while (-dividend >= divisor) {
                    dividend += divisor;
                    res++;
                }
                return -res;
            } else if (dividend < 0 && divisor < 0) {
                // -7/-3
                while (dividend <= divisor) {
                    dividend -= divisor;
                    res++;
                }
                return res;
            }
            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int divide = solution.divide(-2147483648, -1);
            System.out.println(divide);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
