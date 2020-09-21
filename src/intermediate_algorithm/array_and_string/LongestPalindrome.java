package intermediate_algorithm.array_and_string;

import java.util.Arrays;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String input = "babad";
//        String input = "cbbcd";
        System.out.println("{input: " + input + "},\n {output: " + new LongestPalindrome().longestPalindrome(input) + "}");

    }

    /**
     * 思路：  S(a,b) 为回文串(0<=a<b<=n)      --[ S(a+1,b-2) 为回文串且 S(a) == S(b-1)  (当b > a+2)
     *                                      --[ S(a) == S(b-1)   (当b == a+2)
     *                                      --[ true   (当b == a+1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        if (stringLength == 0) {
            return "";
        }
        boolean[][] dp = new boolean[stringLength][stringLength];  // 第一维： 子串长度 - 1   ； 第二维度： 子串起始位置  ；   结果： 是否是palindromes
        boolean hasLongerThis, hasLongerLast = true; // 当前长度 和上一个长度，是否有更长的子串
        String result = s.substring(0, 1);
        Arrays.fill(dp[0], true); // 长度为1, 都是true
        for (int palindromeLength = 2; palindromeLength <= stringLength; palindromeLength++) { // 从长度为2开始数
            hasLongerThis = false;
            for (int palindromeStartPosition = 0; palindromeStartPosition <= stringLength - palindromeLength; palindromeStartPosition++) {
                if (palindromeLength <= 2) {
                    if (s.charAt(palindromeStartPosition) == s.charAt(palindromeStartPosition + 1)) {
                        dp[1][palindromeStartPosition] = true;
                        hasLongerThis = true;
                        if (2 > result.length()) {
                            result = s.substring(palindromeStartPosition, palindromeStartPosition + 2);
                        }
                    }
                } else if (dp[palindromeLength - 3][palindromeStartPosition + 1]
                        && (s.charAt(palindromeStartPosition) == s.charAt(palindromeStartPosition + palindromeLength - 1))) {
                    dp[palindromeLength - 1][palindromeStartPosition] = true;
                    hasLongerThis = true;
                    if (palindromeLength > result.length()) {
                        result = s.substring(palindromeStartPosition, palindromeStartPosition + palindromeLength);
                    }
                }
            }
            if (!hasLongerThis && !hasLongerLast) break;
            hasLongerLast = hasLongerThis;
        }
        return result;
    }
}
