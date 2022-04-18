/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * Related Topics 字符串 动态规划 👍 825 👎 0
 */

package leetcode.editor.cn;


public class PalindromicSubstrings {
    public static void main(String[] args) {

        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 其实就是最长回文子串的统计
         *
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            /**
             * 用求最长回文子串的方式，统计为子串的数目
             *
             * 最长回文子串依赖于求最长公共子串方法
             */


            boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];

            int ans = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1) {
                            ++ans;
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                            if (dp[i][j]) ++ans;
                        }
                    }


                }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}