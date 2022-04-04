/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * <p>
 * <p>
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是
 * [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= arr.length <= 1000
 * <p>
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 873 题相同： https://leetcode-cn.com/problems/length-of-longest-fibonacci-
 * subsequence/
 * Related Topics 数组 哈希表 动态规划 👍 26 👎 0
 */

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class Q91FMA {
    public static void main(String[] args) {

        Solution solution = new Q91FMA().new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {

            /**
             * 思路 DP+Hash
             * dp(m,n) (m>n) 表示索引下标为n,m 的最长fibonacci 长度
             *  badcase 如果没有构成则 dp(m,n) = 2; (因为一旦构成就是3)
             */

            int[][] dp = new int[arr.length][arr.length];

            Map<Integer, Integer> has = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                has.put(arr[i], i);
            }


            int max = 2;

            // dp[1][0] = 2;
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = arr[i] - arr[j];
                    if (has.containsKey(tmp) && has.get(tmp) < j) {
                        dp[i][j] = dp[j][has.get(tmp)] + 1;
                    } else {
                        dp[i][j] = 2;
                    }
                    max = Math.max(max, dp[i][j]);

                }

            }


            return max == 2 ? 0 : max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}