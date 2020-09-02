package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sws
 */

public class FindOddNum {

    class Solution {

        public int findOdd(int[] nums) {
            return findOddNum(nums);
        }


        private int findOddNum(int[] nums) {

            int result = 0;

            for (int num : nums) {
                result ^= num;
            }

            return result;

        }

        private int findOddNum2(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer integer = map.computeIfAbsent(num, k -> 0);
                map.put(num, integer + 1);

            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }
}
