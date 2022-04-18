/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而
 * "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * <p>
 * Related Topics 字符串 动态规划 👍 729 👎 0
 */

package leetcode.editor.cn;


public class DistinctSubsequences {
    public static void main(String[] args) {

        Solution solution = new DistinctSubsequences().new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));
        System.out.println(solution.numDistinct("123", "bag"));
        System.out.println(solution.numDistinct("123", ""));
        System.out.println(solution.numDistinct("", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            /**
             * dp(m,n) 标识s[m:] 与t[n:]的数目
             * badcad n==t.size 即t[n:] 为空集
             *
             * 考虑
             * s[m] == t[n]
             * 如果选s[m] 则有 dp(m,n) = dp(m+1,n+1)
             * 如果不选s[m] 则有dp(m, n) = dp(m+1, n);
             * s[m]!=t[n]
             * dp(m,n) = dp(m+1, n)
             *
             */

            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i < s.length() + 1; i++) {
                dp[i][t.length()] = 1;
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = t.length() - 1; j >= 0; j--) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }

            return dp[0][0];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}