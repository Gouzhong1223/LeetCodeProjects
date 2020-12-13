package com.leetcode.editor.cn;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。
//
//
//
// 示例 1：
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
//
//
// 示例 3：
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
//
//
// 示例 4：
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
//
//
// 示例 5：
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3000
// s 仅由数字组成
//
// Related Topics 字符串 回溯算法
// 👍 467 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P93RestoreIpAddresses {
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> res = new ArrayList<>();
            if (len > 12 || len < 4) {
                return res;
            }
            Deque<String> path = new ArrayDeque<>(4);
            backTrack(s, len, 0, 4, path, res);
            return res;
        }

        private void backTrack(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
            if (begin == len) {
                if (residue == 0) {
                    res.add(String.join(".", path));
                }
                return;
            }
            for (int i = begin; i < begin + 3; i++) {
                if (i >= len) {
                    break;
                }
                if (residue * 3 < len - i) {
                    continue;
                }
                if (judgeIpSegment(s, begin, i)) {
                    String substring = s.substring(begin, i + 1);
                    path.addLast(substring);
                    backTrack(s, len, i + 1, residue - 1, path, res);
                    path.removeLast();
                }

            }
        }

        public boolean judgeIpSegment(String s, int left, int right) {
            int len = right - left + 1;
            if (len > 1 && s.charAt(left) == '0') {
                return false;
            }
            int res = 0;
            while (left <= right) {
                res = res * 10 + s.charAt(left) - '0';
                left++;
            }
            return res >= 0 && res <= 255;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            List<String> strings = solution.restoreIpAddresses("010010");
            strings.forEach(System.out::println);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
