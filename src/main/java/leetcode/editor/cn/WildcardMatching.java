//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法


package leetcode.editor.cn;


public class WildcardMatching {
    public static void main(String[] args) {

        Solution solution = new WildcardMatching().new Solution();
        System.out.println(solution.isMatch("acdcb", "a*c?b"));
        System.out.println(solution.isMatch("adceb", "*a*b"));
        System.out.println(solution.isMatch("aa", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路:
         * 还是老套路 f(m,n) 表示 str1(0....m) 与str2(0...n) 比较
         * <p>
         * 如果str1(m) == str2(n) 那其实就是看f(m-1,n-1)
         * <p>
         * 如果str1(m) == "?"  那其实就是看f(m-1, n-1)
         * <p>
         * 如果str1(m) == "*"  会有两种情况 一种是匹配空串f(m-1, n) 一种是匹配子串f(m,n-1)
         * <p>
         * <p>
         * 所以就是判断 f(m-1,n-1) f(m-1,n) f(m,n-1)
         * <p>
         * 如果存在任意的为true, 且str1(m) 在上面三种情况，那么就是可以匹配上，否则就是不行
         *
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {

            if (s == null && p == null) {
                return true;
            }

            if (p == null) {
                return false;
            }

            if (s == null) {
                if (p.equals("*")) {
                    return true;
                } else {
                    return false;
                }
            }


            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

            // 两个都为null
            dp[0][0] = true;

            // s== null p != null
            for (int i = 1; i <= p.length(); i++) {
                // 如果是比较的是空串，所以如果前面的都是*，就代表是可以匹配上的
                if (p.charAt(i - 1) == '*') {
                    dp[i][0] = true;
                } else {
                    break;
                }
            }


            for (int i = 1; i <= p.length(); i++) {
                for (int j = 1; j <= s.length(); j++) {

                    if (p.charAt(i - 1) == s.charAt(j - 1)
                            || p.charAt(i - 1) == '?') {
                        if (dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }

                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

                    }

                }
            }

            return dp[p.length()][s.length()];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}