//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划


package leetcode.editor.cn;


public class LongestCommonSubsequence {
    public static void main(String[] args) {

        Solution solution = new LongestCommonSubsequence().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("intention", "execution"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路:
         * 1 F(m-1,n-1) 表示str1(0,m-1) str2(0,n-1)最长的子序列数目。
         * 那么 F(m,n) 有几种情况
         * *如果str1(m)==str(n)  那么就需要从F(m-1,n) F(m,n-1) F(m-1,n-1)+1 三个中选择最大的那个
         * *如果str1(m) != str(n) 那么就只需要从(m-1,n) F(m,n-1)  中选最大的那个就好了。
         * <p>
         * 以此类推 F(m-1,n) 有几种情况：
         * *如果str1(m-1)==str(n)  那么就需要从F(m-2,n) F(m-1,n-1) F(m-2,n-1)+1 三个中选择最大的那个
         * *如果str1(m-1) != str(n) 那么就只需要从(m-2,n) F(m,n-2)  中选最大的那个就好了。
         * <p>
         * 所以 F(m-1,n)||F(m,n-1) >= F(m-1,n-1), 所以F(m-1,n-1)+1 一定是>= F(m-1,n) F(m,n-1)
         * <p>
         * 所以 当str1(m)==str(n)  F(m,n) = F(m-1,n-1)+1
         * <p>
         * 遍历的顺序是从左上角到右下角
         *
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence(String text1, String text2) {

            if (null == text1 || null == text2 || text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];

            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }
            }

            return dp[text1.length()][text2.length()];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}