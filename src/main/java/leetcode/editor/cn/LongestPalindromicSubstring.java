//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;


public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("aacdefcaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路1：枚举所有i,j 找出最大的哪一种。 时间复杂度O(n^3)
         * 思路2：该字符串的反序的字符串，与该串的最大连续子串就是最长的回文子串
         * 我们先找最长公共子串长度maxLen, 第一次出现的长度即为
         * <p>
         * * f(m,n) 表示str1(0...m) str2(0...n)的最长子串。
         * * 如果
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {


            if (null == s || s.length() == 1) {
                return s;
            }

            int size = s.length();

            int[][] dpCount = new int[size + 1][size + 1];


            // 翻转
            String rever = new StringBuffer(s).reverse().toString();

            int cur = 0;
            int end = -1;

            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {

                    if (s.charAt(i - 1) == rever.charAt(j - 1)) {

                        if (i - 1 == 0 || j - 1 == 0) {
                            dpCount[i][j] = 1;
                        } else {
                            dpCount[i][j] = dpCount[i - 1][j - 1] + 1;
                        }
                    }

                    if (cur < dpCount[i][j]) {

                        // 这里要判断是否是真正的回文 覆盖aacdefcaa 这种case

                        // 如果j与i是长度为dpCount[i][j] 的回文，那么i+dpCount[i][j]一定是j对应的正序的下标

                        // 例如aacdefcaa 中的最长回文为第一个a(1)a(2)(第二aa也是，我们只拿第一个aa举例)
                        // 正序a(i=1)a(i=2)   那反序就是a(j=9 对应i=1)a(j=8,对应i=2).
                        // dp[2][2] == dp[i=2][j=8] str[0:2]
                        // 则按照正序来讲就有len-j-1(j对应的正序，因为实际是len-j那个位置上的 跟i相等，所以需要额外-1)
                        // + dpCount(中间间隔的长度) = i

                        // 注意 因为我们的下标就是从1开始的,所以不需要再额外-1
                        if (size - j + dpCount[i][j] == i) {
                            cur = dpCount[i][j];
                            end = i - 1; // 循环里面的i，对应实际字符串中的就是i-1
                        }
                    }
                }

            }


//            System.out.println(cur);
//            System.out.println(end);
//            System.out.println(s.substring(end - cur + 1, end + 1));


            return s.substring(end - cur + 1, end + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
