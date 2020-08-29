//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 552 👎 0


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

        Solution solution = new FourSum().new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            Arrays.sort(nums);
            return nSumTarget(nums, 4, 0, target);
        }

        private List<List<Integer>> nSumTarget(int[] nums, int step, int start, int target) {

            List<List<Integer>> result = new ArrayList<>();
            if (step == 2) {
                // 这里进行二维双指针
                return twoSumTarget(nums, start, target);
            } else {

                for (int i = start; i < nums.length; i++) {
                    List<List<Integer>> lists = nSumTarget(nums, step - 1, i + 1, target - nums[i]);
                    if (!lists.isEmpty()) {
                        for (List<Integer> list : lists) {
                            list.add(nums[i]);
                            result.add(list);
                        }

                    }
                    while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
                }
            }
            return result;

        }


        // 记录可以构成target的value
        private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {

            List<List<Integer>> res = new ArrayList<>();

            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];

                int sum = leftNum + rightNum;
                if (sum < target) {
                    while (nums[left] == leftNum && left < right) left++;
                } else if (sum > target) {
                    while (nums[right] == rightNum && left < right) right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(leftNum);
                    list.add(rightNum);
                    res.add(list);
                    while (nums[left] == leftNum && left < right) left++;
                    while (nums[right] == rightNum && left < right) right--;
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}