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

            int[] count = new int[58];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'A']++;
            }

            int ans = 0;

            for (int num : count) {
                ans += num / 2 * 2;
                if (num % 2 == 1 && ans % 2 == 0) {
                    ++ans;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}