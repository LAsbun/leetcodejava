/**
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/
 * Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 24 👎 0
 */

package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class G5c51o {
    public static void main(String[] args) {

        Solution solution = new G5c51o().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> timeMap = new HashMap<>();

            for (int num : nums) {
                timeMap.put(num, timeMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());

            for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
                queue.add(entry);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            int[] ans = new int[k];
            int i = 0;

            while (!queue.isEmpty()) {
                ans[i++] = queue.poll().getKey();
            }

            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}