//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 304 👎 0


package leetcode.editor.cn;


public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {

        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        System.out.println(solution.singleNumber(new int[]{3, 4, 3, 3}));
        System.out.println(solution.singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
        System.out.println(solution.singleNumber(new int[]{9, Integer.MAX_VALUE, 7, 9, 7, 9, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] byt = new int[32];

            for (int num : nums) {
                for (int i = 0; i <= 31; i++) {
                    if ((num & 1 << i) != 0) {
                        byt[i]++;
                    }
                }

            }

            int ans = 0;

            for (int i = 0; i <= 31; i++) {
                if (byt[i] % 3 != 0) {
                    ans += 1 << i;
                }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}