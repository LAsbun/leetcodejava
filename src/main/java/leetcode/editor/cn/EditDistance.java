//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;


public class EditDistance {
    public static void main(String[] args) {

        Solution solution = new EditDistance().new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
        System.out.println(solution.minDistance("", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {

            return solutionDp(word1, word2);
        }


        /**
         * 动态规划,只操作一个字符串
         * <p>
         * f(m,n)表示str1(0..m) 转换成str2(0...n) 需要修改的次数。
         * <p>
         * 如果str1[m] == str2[n] 那么问题就转换成了f(m-1,n-1)
         * * f(m,n) == f(m-1,n-1)
         * <p>
         * 如果str1[m] != str2[n] 那么就会有下面几种转换方式:
         * * 插入 那么就是str1[m+1] == str2[n] 即str1[m]==str2[n-1] 问题就转换成了f(m,n-1)
         * * 删除 那么就是str1[m-1] == str2[n] 问题就转换成了f(m-1,n)
         * * 修改 那么就是str1[m-1] == str2[n-1] 问题就转换成了f(m-1,n-1)
         * <p>
         * * 那么f(m,n) == min(f(m-1,n-1),f(m-1,n),f(m,n-1)) +1
         *
         * @param word1
         * @param word2
         * @return
         */
        private int solutionDp(String word1, String word2) {

            if (null == word1 && null == word2) {
                return 0;
            }

            if (null == word1) {

                return word2.length();
            }
            if (null == word2) {

                return word1.length();
            }


            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= word2.length(); i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {

                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }

                }
            }

            return dp[word1.length()][word2.length()];

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}