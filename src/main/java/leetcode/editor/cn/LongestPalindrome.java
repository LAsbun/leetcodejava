//Given a string which consists of lowercase or uppercase letters, find the leng
//th of the longest palindromes that can be built with those letters. 
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
// 
//
// Note: 
//Assume the length of given string will not exceed 1,010.
// 
//
// Example: 
// 
//Input:
//"abccccdd"
//
//Output:
//7
//
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
// 
// Related Topics 哈希表


package leetcode.editor.cn;


public class LongestPalindrome {

    public static void main(String[] args) {

        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("aacdefcaa"));
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestPalindrome(String s) {

            if (null == s) {
                return 0;
            }

            if (s.length() == 1) {
                return 1;
            }

            int size = s.length();

            int[][] dpCount = new int[size + 1][size + 1];


            // 翻转
            String rever = new StringBuffer(s).reverse().toString();

            int cur = 0;

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
                        }
                    }
                }

            }


            return cur;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}