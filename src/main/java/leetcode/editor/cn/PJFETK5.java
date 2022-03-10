//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 21 👎 0


package leetcode.editor.cn;

//Java：二进制加法
public class PJFETK5 {
    public static void main(String[] args) {
        Solution solution = new PJFETK5().new Solution();
        // TO TEST
        System.out.println(solution.addBinary("11", "10"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("111", "111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {

            int alength = a.length();
            int bLength = b.length();

            int i = alength - 1;
            int j = bLength - 1;
            int pre = 0;

            StringBuilder builder = new StringBuilder();

            while (i >= 0 && j >= 0) {
                int i1 = a.charAt(i) - '0' + (int) b.charAt(j) - '0' + pre;
                if (i1 > 1) {
                    i1 -= 2;
                    pre = 1;
                } else {
                    pre = 0;
                }
                builder.append(i1);
                --i;
                --j;
            }

            while (i >= 0) {
                int i1 = (int) a.charAt(i) - '0' + pre;
                if (i1 > 1) {
                    i1 -= 2;
                    pre = 1;
                } else {
                    pre = 0;
                }
                builder.append(i1);
                --i;
            }

            while (j >= 0) {
                int i1 = (int) b.charAt(j) - '0' + pre;
                if (i1 > 1) {
                    i1 -= 2;
                    pre = 1;
                } else {
                    pre = 0;
                }
                builder.append(i1);
                --j;
            }

            if (pre != 0) {
                builder.append(pre);
            }

            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
