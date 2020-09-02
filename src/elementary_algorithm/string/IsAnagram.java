package elementary_algorithm.string;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * ps: anagram, 相同字母异序词，易位构词，变位词
 */
public class IsAnagram {
    public static void main(String[] args) {
//        String inputA = "anagram", inputB = "nagaram";
        String inputA = "rat", inputB = "car";
        System.out.println("{inputA = " + inputA + "}, {inputB = " + inputB + "}, {output(isAnagram) = " + isAnagram(inputA, inputB) + "}");
    }

    public static boolean isAnagram(String s, String t) {
        char[] stringA = s.toCharArray(), stringB = t.toCharArray();
        Arrays.sort(stringA);
        Arrays.sort(stringB);
        return String.valueOf(stringA).equals(String.valueOf(stringB));
    }
}
