/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= envelopes.length <= 10⁵
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 10⁵
 * <p>
 * Related Topics 数组 二分查找 动态规划 排序 👍 698 👎 0
 */

package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {

        Solution solution = new RussianDollEnvelopes().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 5}, {5, 5}, {5, 4}, {5, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {

            /**
             * 最长递增子序列变种， 排序的时候按照w从小到大，h从大到小. 则并根据h获取最长递增子序列即可
             */

            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                }
            });

            // 状态转移方程，如果i>i-1  dp(n) = dp(n)+1  否则  dp(n) = max(dp(0~n-1))+1
            int[] pile = new int[envelopes.length];

            int pileIndex = 0;

            for (int i = 0; i < envelopes.length; i++) {
                // 初始化
                int curNum = envelopes[i][1];

                int left = 0, right = pileIndex;

                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (pile[mid] < curNum) {
                        left = mid + 1;
                    }
                    //else if (pile[mid] == curNum) {
                    //    right = mid;
                    //}
                    else {
                        right = mid;
                    }
                }
                if (left == pileIndex) pileIndex++;

                pile[left] = curNum;


            }


            return pileIndex;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}