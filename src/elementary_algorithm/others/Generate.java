package elementary_algorithm.others;

import elementary_algorithm.math.RomanToInt;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xncfnv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Generate {
    public static void main(String[] args) {
        int input = 5;
        System.out.println("{input: " + input + "}, {output: " + new Generate().generate(input) + "}");
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> tmp1 = new ArrayList<>(), tmp2 = new ArrayList<>();
        tmp2.add(1);
        result.add(tmp2);
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            tmp1 = tmp2;
            tmp2 = new ArrayList<>();
            tmp2.add(1);
            for (int j = 0; j < i - 1; j++) {
                tmp2.add(tmp1.get(j) + tmp1.get(j + 1));
            }
            tmp2.add(1);
            result.add(tmp2);
        }
        return result;
    }
}
