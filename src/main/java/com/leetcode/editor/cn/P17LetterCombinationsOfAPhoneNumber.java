package com.leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法
// 👍 979 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P17LetterCombinationsOfAPhoneNumber {
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            ArrayList<String> combinations = new ArrayList<>();
            if (digits.length() == 0) {
                return combinations;
            }
            HashMap<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            bacjktrack(combinations, phoneMap, digits, 0, new StringBuilder());
            return combinations;
        }

        private void bacjktrack(ArrayList<String> combinations, HashMap<Character, String> phoneMap,
                                String digits, int index, StringBuilder combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    bacjktrack(combinations, phoneMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }


            }
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}
