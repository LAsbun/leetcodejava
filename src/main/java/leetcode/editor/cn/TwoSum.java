//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8983 👎 0


package leetcode.editor.cn;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] ints = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            int index = 0;
            for (int num : nums) {
                List<Integer> list = map.computeIfAbsent(num, k -> new ArrayList<>());
                list.add(index);
                ++index;
            }

            for (int num : nums) {
                int result = target - num;
                if (map.containsKey(result)) {
                    List<Integer> list = map.get(num);
                    if (num == result && list.size() == 2) {
                        return new int[]{list.get(0), list.get(1)};
                    }
                    if (num != result) {
                        List<Integer> resu = map.get(result);
                        return new int[]{list.get(0), resu.get(0)};
                    }

                }
            }

            return new int[]{-1, -1};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

