//
//Given a string s, find the longest palindromic subsequence's length in s. You 
//may assume that the maximum length of s is 1000.
// 
//
// Example 1: 
//Input: 
// 
//"bbbab"
// 
//Output: 
// 
//4
// 
//One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//Input:
// 
//"cbbd"
// 
//Output:
// 
//2
// 
//One possible longest palindromic subsequence is "bb".
// Related Topics 动态规划


package leetcode.editor.cn;


public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubsequence().new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * /**
         * * 思路1：枚举所有i,j 找出最长的那个。 时间复杂度O(n^3)
         * * 思路2：
         * * 对于一个[i,j]的字符串， 时间复杂度O(n^2)
         * * 如果i == j
         * * 那么最大就是[i,j] = [i+1][j-1]+2
         * * else:
         * * [i,j] = max([[i+1, j], [i, j-1])
         *
         * @param s
         * @return
         */
        public int longestPalindromeSubseq(String s) {
            if (null == s) {
                return 0;
            }

            int size = s.length();

            int[][] dpCount = new int[size][size];


            // 每个字段自己就是一个回文
            for (int i = 0; i < size; i++) {
                dpCount[i][i] = 1;
            }

            for (int i = size - 1; i >= 0; i--) {
                for (int j = i + 1; j < size; j++) {

                    if (s.charAt(i) == s.charAt(j)) {
                        dpCount[i][j] = dpCount[i + 1][j - 1] + 2;
                    } else {
                        dpCount[i][j] = dpCount[i + 1][j] > dpCount[i][j - 1] ? dpCount[i + 1][j] : dpCount[i][j - 1];
                    }

                }


            }

            return dpCount[0][size - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}