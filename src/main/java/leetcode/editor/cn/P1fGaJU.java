//给定一个包含 n 个整数的数组 nums，
// 判断 nums 中是否存在三个元素 a ，b ，c ，
// 使得 a + b + c = 0 ？请找出所有和为 0 且
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 41 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：数组中和为 0 的三个数
public class P1fGaJU {
    public static void main(String[] args) {
        Solution solution = new P1fGaJU().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();

            int ihead = 0;
            int itail = nums.length - 1;

            for (; ihead <= itail; ihead++) {

                int tmpResult = -nums[ihead];
                int head = ihead + 1;
                int tail = itail;

                while (head < tail && head < nums.length) {
                    int tmpHeadTail = nums[head] + nums[tail];
                    if (tmpResult == tmpHeadTail) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[ihead]);
                        tmp.add(nums[head]);
                        tmp.add(nums[tail]);
                        result.add(tmp);
                        // 不重复
                        while (head + 1 < nums.length && nums[head + 1] == nums[head]) {
                            ++head;
                        }
                        // 不重复
                        while (tail - 1 > head && nums[tail - 1] == nums[tail]) {
                            --tail;
                        }
                        //各自++ 或--
                        ++head;
                        --tail;

                    } else if (tmpResult < tmpHeadTail) {
                        tail--;
                    } else {
                        head++;
                    }

                    // 不重复
                    while (ihead + 1 < nums.length && nums[ihead + 1] == nums[ihead]) {
                        ++ihead;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
