//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 584 👎 0


package leetcode.editor.cn;


import java.util.Arrays;

public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {

        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.singleNumbers(new int[]{4, 1, 4, 6})));
        System.out.println(Arrays.toString(solution.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {

            /**
             * 还是基于位运算 异或 abor
             * 先求出两个不同数字的异或结果。 根据异或的性质，找出abor中为1的值。根据此值进行分组，然后根据分组进行异或即可算出结果。
             */
            int abor = nums[0];
            for (int i = 1; i < nums.length; i++) {
                abor ^= nums[i];
            }

            int tmp = 1;

            while ((tmp & abor) == 0) {
                tmp <<= 1;
            }

            int a = 0;
            int b = 0;
            for (int num : nums) {
                if ((num & tmp) != 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }

            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}