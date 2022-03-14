//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 459 👎 0


package leetcode.editor.cn;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {

        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(2, 3, 0));
        System.out.println(solution.movingCount(3, 2, 17));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            // 正常bfs||dfs即可

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{0, 0});

            boolean[][] bool = new boolean[m][n];

            int ans = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                if (poll[1] >= n || poll[0] >= m || sum(poll[0]) + sum(poll[1]) > k || bool[poll[0]][poll[1]]) continue;
                ans += 1;
                bool[poll[0]][poll[1]] = true;

                queue.add(new int[]{poll[0] + 1, poll[1]});
                queue.add(new int[]{poll[0], poll[1] + 1});
            }
            return ans;

        }

        private int sum(int x) {
            int sum = 0;

            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}