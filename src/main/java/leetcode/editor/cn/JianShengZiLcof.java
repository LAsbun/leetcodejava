//////给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-
//1]
//// 。
//////请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最
//大乘
////积是18
//////。 
//////
////// 示例 1： 
//////
////// 输入: 2
//////输出: 1
//////解释: 2 = 1 + 1, 1 × 1 = 1 
//////
////// 示例 2: 
//////
////// 输入: 10
//////输出: 36
//////解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//////
////// 提示： 
//////
////// 
////// 2 <= n <= 58 
////// 
//////
////// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
////// Related Topics 数学 动态规划 👍 386 👎 0
////
//


package leetcode.editor.cn;

//Java：剪绳子
public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        // TO TEST
        //System.out.println(solution.cuttingRope(10));
        //System.out.println(solution.cuttingRope(2));
        for (int i = 1000; i >= 2; i--) {
            if (solution.cuttingRope(i) >= 999975365){
                System.out.println(i);
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            // 数学
            // 尽量都剪成段长为3的小段. 如果为1 的话，则将最后一个3+1=4;
            // 如果<=3 因为必须剪去一个1，即分成两段，所以是n-1
            if (n <= 3) return n - 1;
            int p = n / 3;
            int mod = n % 3;
            if (mod == 1) return (int) Math.pow(3, p - 1) * 4;
            if (mod == 2) return (int) Math.pow(3, p) * 2;
            return (int) Math.pow(3, p);

            // 动态规划思路
            /**
             * 状态转移方程．　dp[n] = max(dp[n], (n-j)*j, (n-j)*j) [j=  0~n]
             */
            /**
             *
             int[] dp = new int[n + 1];

             dp[2] = 1;
             for (int i = 3; i < n + 1; i++) {
             // 按照最大的切分
             for (int j = 1; j < i; j++) {
             dp[i] = Math.max(Math.max(dp[i], (i - j) * j), dp[i - j] * j);
             }
             }

             return dp[n];
             */

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

