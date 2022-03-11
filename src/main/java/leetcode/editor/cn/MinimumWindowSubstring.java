//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1692 👎 0


package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        Solution solution = new MinimumWindowSubstring().new Solution();
        //System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("aa", "aa"));
        //System.out.println(solution.minWindow("a", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";

            Map<Character, Integer> ori = new HashMap<>();
            Map<Character, Integer> cur = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                char key = t.charAt(i);
                putNewChar(ori, key);
            }

            int left = 0;
            int right = 0;

            int ansLeft = Integer.MAX_VALUE;

            int minLen = Integer.MAX_VALUE;

            int valid = 0;

            while (right < s.length()) {
                char key = s.charAt(right);
                if (ori.containsKey(key)) {
                    putNewChar(cur, key);
                    if (ori.get(key).equals(cur.get(key))) {
                        valid++;
                    }
                }
                ++right;
                while (valid == ori.size() && left < right) {
                    if (right - left < minLen) {
                        ansLeft = left;
                        minLen = right - left;
                    }
                    char leftKey = s.charAt(left);
                    if (ori.containsKey(leftKey)) {
                        if (ori.get(leftKey).equals(cur.get(leftKey))) {
                            valid--;
                        }
                        popNewChar(cur, leftKey);
                    }
                    ++left;

                }


            }

            return Integer.MAX_VALUE == minLen ? "" : s.substring(ansLeft, ansLeft + minLen);
        }

        private void putNewChar(Map<Character, Integer> ori, char key) {
            if (ori.containsKey(key)) {
                Integer remove = ori.remove(key);
                ori.put(key, remove + 1);
            } else {
                ori.put(key, 1);
            }
        }

        private void popNewChar(Map<Character, Integer> ori, char key) {
            Integer integer = ori.remove(key) - 1;
            if (integer > 0) {
                ori.put(key, integer);
            }
        }


        private boolean judge(Map<Character, Integer> ori, Map<Character, Integer> cur) {
            for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
                if (!cur.containsKey(entry.getKey()) || cur.get(entry.getKey()).compareTo(entry.getValue()) < 0) {
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}