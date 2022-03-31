/**
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
 * array/
 * Related Topics 数组 二分查找 👍 23 👎 0
 */

package leetcode.editor.cn;


public class SkFtm2 {
    public static void main(String[] args) {

        Solution solution = new SkFtm2().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            /**
             * 二分
             */

            if (nums.length < 2) return nums[0];

            int start = 0, end = nums.length - 1;

            while (start < end) {
                int mid = (end - start) / 2 + start;
                // 因为数组是从下标0开始，
                // 如果mid是奇数 且mid == mid-1  即左边是偶数
                // 如果mid是偶数 且mid == mid+1 即mid+1左边是偶数
                if (nums[mid] == nums[mid ^ 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return nums[start];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}