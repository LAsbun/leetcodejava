//给定一个数组，包含从 1 到 N 所有的整数，
// 但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000
// 
// Related Topics 数组 数学 
// 👍 24 👎 0


package leetcode.editor.cn;


import java.util.Arrays;

public class MissingTwoLcci {
    public static void main(String[] args) {

        Solution solution = new MissingTwoLcci().new Solution();
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1})));
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1,4})));
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1,3,5})));
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{2,3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            // sum1 = 1+2...+n - sum(nums) = x+y
            // mid = sum1//2
            // x = 1+2.+mid - sum(for num in nums if num < mid)
            // y = sum1-x
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            int totalSum = sumN(nums.length + 2);

            int xY = totalSum - sum;
            int mid = xY / 2;

            int midSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    midSum += nums[i];
                }
            }

            int x = sumN(mid) - midSum;
            int y = xY - x;


            return new int[]{x, y};
        }

        private int sumN(int length) {
            return (length + 1) * (length) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}