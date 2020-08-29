//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2526 👎 0


package leetcode.editor.cn;


import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            return threeSumTarget(nums, 0);

        }


        private List<List<Integer>> threeSumTarget(int[] nums, int target) {

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - nums[i]);
                if (!lists.isEmpty()) {
                    for (List<Integer> list : lists) {
                        list.add(nums[i]);
                        result.add(list);
                    }

                }

                while (i + 1 <= nums.length - 1 && nums[i] == nums[i + 1]) ++i;
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