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
// Related Topics 数组 滑动窗口 👍 48 👎 0


package leetcode.editor.cn;


public class ZVAVXX {
    public static void main(String[] args) {

        Solution solution = new ZVAVXX().new Solution();

        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {


            // 优化 如果 num[i+1]*..*num[i+n] < n. 则其子数组的乘积都小于k. 则解为 n(N+1)/2
            // 如果num[i+1]*..*num[i+n+1] < n  则其子数组的解为 (n+1)(n+2)/2.
            // 即 left不变，right+1， 则新增解为n(right-left)+1.

            int ans = 0;

            int left = 0;
            int right = 0;

            int product = 1;


            while (right < nums.length) {
                product *= nums[right];

                // 如果是大于k, 则移动左窗口
                while (left <= right && product >= k) {
                    product /= nums[left];
                    ++left;
                }

                // 这里是因为如果单一某一个就比k大, 则按照上面left == right
                // left <= right 说明存在小于k的子数组
                if (left <= right) {
                    ans += (right - left + 1);
                }
                // 最后right+1 是因为成绩是[left,right]. 如果先加right+1 就不对了
                right++;


            }
            return ans;
        }

        //public int numSubarrayProductLessThanK(int[] nums, int k) {
        //    int ans = 0;
        //
        //    int left = 0;
        //
        //    while (left < nums.length) {
        //        int tmp = nums[left];
        //        if (tmp < k) {
        //            ++ans;
        //        }
        //        int right = left + 1;
        //
        //        while (right < nums.length && tmp * nums[right] < k) {
        //            ++ans;
        //            tmp *= nums[right];
        //            ++right;
        //        }
        //        ++left;
        //    }
        //    return ans;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}