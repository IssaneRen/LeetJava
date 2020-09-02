package elementary_algorithm.string;

import util.CommonUtils;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = new String[] {"flower","flow","flight"};
        System.out.println("{input = " + CommonUtils.array2String(input) + "}, {output(longestCommonPrefix) = " + longestCommonPrefix(input) + "}");
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        boolean same = true;
        int position = 0;
        while (true) {
            try {
                for (int i = 0; i < strs.length-1; i++) {
                    if (strs[i].charAt(position) != strs[i + 1].charAt(position)) {
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    break;
                } else {
                    result.append(strs[0].charAt(position));
                    position++;
                }
            } catch (IndexOutOfBoundsException exception) {
                return result.toString();
            }
        }
        return result.toString();
    }
}
