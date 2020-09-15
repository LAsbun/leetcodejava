//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4311 👎 0


package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            return solu2(s);
        }

        private int solu2(String s) {
            if (null == s || s.length() == 0) {
                return 0;
            }

            Map<Character, Integer> map = new HashMap<>();

            int left = 0;
            int max = -1;

            for (int i = 0; i < s.length(); i++) {

                char key = s.charAt(i);
                if (map.containsKey(key)) {
                    // 这里为什么要+1 是因为left 本身遇到重复也是要前进的。就是收尾不能重复
                    // 为什么要max map中的值可能会小于left. left要保持最大的
                    left = Math.max(left, map.get(key) + 1);
                }

                map.put(key, i);
                max = Math.max(i - left + 1, max);

            }

            return max;
        }

        private int solu1(String s) {
            if (null == s || s.length() == 0) {
                return 0;
            }
            int length = s.length();

            boolean[] inclu = new boolean[1000];

            char c = (char) 0;

            int left = 0;
            int right = 0;
            int max = -1;

            while (left <= right && right < length) {

                while (right < length && !inclu[s.charAt(right) - c]) {
                    inclu[s.charAt(right) - c] = true;
                    ++right;
                }

                max = Math.max(max, right - left);

                if (right >= length) {
                    break;
                }

                while (left < right && s.charAt(left) != s.charAt(right)) {
                    inclu[s.charAt(left) - c] = false;
                    ++left;
                }
                if (left < right) {
                    inclu[s.charAt(left) - c] = false;
                    ++left;
                }

            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}