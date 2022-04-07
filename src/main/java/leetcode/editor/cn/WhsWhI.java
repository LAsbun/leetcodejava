/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
 * sequence/
 * Related Topics 并查集 数组 哈希表 👍 26 👎 0
 */

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class WhsWhI {
    public static void main(String[] args) {

        Solution solution = new WhsWhI().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 2, 4, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int longestConsecutive(int[] nums) {

            /**
             * 并查集解法：将 num-1, num, num+1 视为不同节点，进行连接，找到最长的点即可
             */


            if (nums.length < 2) return nums.length;


            UnionFind unionFind = new UnionFind(nums);

            for (int num :
                    nums) {
                unionFind.union(num, num + 1);
            }

            int max = 1;

            for (int num :
                    nums) {
                max = Math.max(max, unionFind.find(num) - num + 1);
            }

            return max;
        }

        private class UnionFind {

            private Map<Integer, Integer> fa = new HashMap<>();

            public UnionFind(int[] nums) {
                for (int num :
                        nums) {
                    fa.put(num, num);
                }
            }

            public Integer find(int x) {
                if (fa.get(x) != x) {
                    fa.put(x, find(fa.get(x)));
                }
                return fa.get(x);
            }

            private void union(int x, int y) {
                if (fa.containsKey(y)) fa.put(x, y); // y是x的父节点
            }

        }


        public int longestConsecutive2(int[] nums) {

            if (nums.length == 0) return 0;

            int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;

            Map<Integer, Integer> objectObjectHashMap = new HashMap<>();

            for (int num : nums) {
                maxNum = Math.max(num, maxNum);
                minNum = Math.min(num, minNum);

                objectObjectHashMap.put(num, objectObjectHashMap.getOrDefault(num, 0) + 1);
            }

            int maxLen = -1;
            for (int num : nums) {

                // 为什么是-1 因为-1表示从当前开始
                if (!objectObjectHashMap.containsKey(num - 1)) {
                    int curNum = num;
                    int tmpMax = 1;
                    while (objectObjectHashMap.containsKey(curNum + 1)) {
                        curNum += 1;
                        tmpMax += 1;
                    }
                    maxLen = Math.max(maxLen, tmpMax);
                }


            }


            return maxLen;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}