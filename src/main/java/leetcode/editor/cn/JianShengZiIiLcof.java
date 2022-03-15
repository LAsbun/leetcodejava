//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//

// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 172 👎 0


package leetcode.editor.cn;


import java.math.BigInteger;
import java.util.Arrays;

//Java：剪绳子 II
public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        // TO TEST
        System.out.println(solution.cuttingRope(120));
        //for (int i = 1000; i >= 2; i--) {
        //    if (solution.cuttingRope(i) >= 999975365) {
        //        System.out.println(i);
        //    }
        //}
        //System.out.println(solution.cuttingRope(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //import java.math.BigInteger;

    class Solution {
        final static int N = 1000000007;

        public int cuttingRope(int n) {
            BigInteger[] dp = new BigInteger[n + 1];
            Arrays.fill(dp, BigInteger.valueOf(0));

            dp[2] = BigInteger.valueOf(1);
            for (int i = 3; i < n + 1; i++) {
                // 按照最大的切分
                for (int j = 1; j < i; j++) {
                    dp[i] = dp[i].max(BigInteger.valueOf((i - j) * j)).max(dp[i - j].multiply(BigInteger.valueOf(j)));
                }
            }

            return dp[n].mod(BigInteger.valueOf(N)).intValue();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
