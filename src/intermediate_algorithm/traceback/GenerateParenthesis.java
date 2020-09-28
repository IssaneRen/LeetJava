package intermediate_algorithm.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv33m7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int input = 4;
        System.out.println("TEST PROGRAM: ========== \ninput: " + input
                + "\n letterCombinations:\n " + new GenerateParenthesis().generateParenthesis(input)
                + "\n count:  " + new GenerateParenthesis().generateParenthesis(input).size());

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }



    public void generateParenthesis(List<String> result, String currentString, int leftWait, int rightWait) {
        if (rightWait <= 0) {
            result.add(currentString);
            return;
        }

        if (leftWait == rightWait) {
            generateParenthesis(result, currentString + "(", leftWait - 1, rightWait);
        } else {
            if (leftWait - 1 >= 0)
                generateParenthesis(result, currentString + "(", leftWait - 1, rightWait);
            generateParenthesis(result, currentString + ")", leftWait, rightWait - 1);
        }
    }
}
