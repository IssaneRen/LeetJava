package intermediate_algorithm.array_and_string;

import util.CommonUtils;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv2kgi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String input = "1";
        System.out.println("{input: " + input + "},\n {output: " + new LengthOfLongestSubstring().lengthOfLongestSubstring(input) + "}");
    }

    public int lengthOfLongestSubstring(String s) {
        int startCursor = 0, endCursor = 0, result = 0, currentMax = 0;
        char tmp, compareA;
        boolean[] record = new boolean[128]; // ASCII 码中的全部字母都记录
        while (endCursor < s.length()) {
            tmp = s.charAt(endCursor);
            if (!record[tmp]) { // 当前若未被记录
                record[tmp] = true;
                currentMax++;
                endCursor++;
                continue;
            }
            result = Math.max(currentMax, result); // 当前最大和之前最大取更大
            while (startCursor < endCursor) {
                compareA = s.charAt(startCursor);
                record[compareA] = false;
                currentMax--;
                startCursor++;
                if (compareA == tmp) {
                    break;
                }
            }
        }
        result = Math.max(currentMax, result); // 当前最大和之前最大取更大
        return result;
    }
}
