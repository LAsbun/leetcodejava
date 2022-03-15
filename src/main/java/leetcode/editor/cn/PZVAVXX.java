//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 👍 47 👎 0


package leetcode.editor.cn;

//Java：乘积小于 K 的子数组
public class PZVAVXX {
    public static void main(String[] args) {
        Solution solution = new PZVAVXX().new Solution();
        // TO TEST
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans = 0;

        public int numSubarrayProductLessThanK(int[] nums, int k) {
            //// dfs 超时
            //
            //ans = 0;
            //
            //for (int i = 0; i < nums.length; i++) {
            //    doFind(nums, i, nums[i], k);
            //}
            //
            //return ans;


            // 参考连续子数组之和小于N

            int left = 0;
            int right = 0;
            ans = 0;

            int curProduct = 1;

            while (right < nums.length) {
                curProduct *= nums[right];

                while (left <= right && curProduct >= k) {
                    curProduct /= nums[left];
                    ++left;

                }
                if (left <= right) {
                    ans += (right - left + 1);
                }
                right++;


            }
            return ans;


        }

        // 超时了。
        private void doFind(int[] nums, int index, int curProduct, int k) {
            if (index >= nums.length || curProduct >= k) return;

            ++ans;
            ++index;
            if (index >= nums.length) return;
            curProduct *= nums[index];
            doFind(nums, index, curProduct, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
