//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 48 👎 0


package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class QTMn0o {
    public static void main(String[] args) {

        Solution solution = new QTMn0o().new Solution();
        //System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        //System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution.subarraySum(new int[]{-1, -1, 1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int sum = 0;

            Map<Integer, Integer> map = new HashMap<>();

            int ans = 0;


            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int tmp = sum - k;
                // 单个，或者是前面的累加和.
                if (tmp == 0) {
                    ans++;
                }
                ans += map.getOrDefault(tmp, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}