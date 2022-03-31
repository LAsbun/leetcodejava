//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 👍 381 👎 0


package leetcode.editor.cn;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NgeTouZiDeDianShuLcof {
    public static void main(String[] args) {

        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.dicesProbability(1)));
        System.out.println(Arrays.toString(solution.dicesProbability(2)));
        System.out.println(Arrays.toString(solution.dicesProbability(3)));
        System.out.println(Arrays.toString(solution.dicesProbability(4)));
        System.out.println(Arrays.toString(solution.dicesProbability(5)));
        System.out.println(Arrays.toString(solution.dicesProbability(6)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double[] dicesProbability(int n) {

            /**
             * 动态规划
             */
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0/6);

            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[5*i+1];
                for (int j = 0; j < dp.length; j++) {

                    for (int k = 0; k < 6; k++) {
                        // 这里是要+1/6
                        tmp[j+k] += dp[j]/6.0;
                    }
                }
                dp = tmp;
            }
            return dp;
        }
        //Map<Integer, Integer> map;
        //
        //public double[] dicesProbability(int n) {
        //    map = new TreeMap<>();
        //
        //    doEnum(0, n);
        //
        //    double sum = 0.0;
        //    for (Integer value : map.values()) {
        //        sum += value;
        //    }
        //
        //    double[] ans = new double[map.size()];
        //    System.out.println(map.size());
        //    System.out.println(Arrays.toString(map.keySet().toArray(new Integer[0])));
        //    System.out.println(Arrays.toString(map.values().toArray(new Integer[0])));
        //
        //    int i = 0;
        //    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
        //        ans[i++] = (integerIntegerEntry.getValue() + 0.0) / sum;
        //    }
        //
        //
        //    return ans;
        //
        //
        //}
        //
        //private void doEnum(int sum, int n) {
        //    if (n == 0) {
        //        map.put(sum, map.getOrDefault(sum, 0) + 1);
        //        return;
        //    }
        //
        //    for (int i = 1; i <= 6; i++) {
        //
        //        doEnum(sum + i, n - 1);
        //
        //    }
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}