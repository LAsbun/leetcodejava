//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
// 
//
// Example 2: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 3: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics 哈希表 数学 字符串 👍 1737 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：Roman to Integer
public class P13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("III"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static Map<String, Integer> map = new HashMap<String, Integer>(7);
    static Map<String, Integer> map2 = new HashMap<String, Integer>(6);
    static Map<Character, Character> map3 = new HashMap<Character, Character>(6);
    static Set<Character> setA = new HashSet<Character>(3);

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map2.put("IV", 4);
        map2.put("IX", 9);
        map2.put("XL", 40);
        map2.put("XC", 90);
        map2.put("CD", 400);
        map2.put("CM", 900);

        map3.put('V', 'I');
        map3.put('X', 'I');
        map3.put('L', 'X');
        map3.put('C', 'X');
        map3.put('D', 'C');
        map3.put('M', 'C');

        setA.add('I');
        setA.add('X');
        setA.add('C');

    }

    public int romanToInt(String s) {
        int sum = 0;

        int length = s.length();
        if (length <= 0) {
            return sum;
        }

        int cur = 0;

        while (cur < length) {
            Character c = s.charAt(cur);
            if (setA.contains(c)) {
                int next = cur + 1;
                if (next < length && c.equals(map3.get(s.charAt(next)))) {
                    sum += map2.get(new String(new char[]{c, s.charAt(next)}));
                    cur = next+1;
                    continue;
                }

            }
            sum += map.get(String.valueOf(c));
            ++cur;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
