package elementary_algorithm;

import util.CommonUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] array = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("{result: " + isValidSudoku(array) + "};");
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board[0] == null || board.length != 9 || board[0].length != 9) {
            return false; // illegal
        }
        Set<Integer>[] lineSet = new HashSet[]{new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9)};
        Set<Integer>[] rowSet = new HashSet[]{new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9)};
        Set<Integer>[] squareSet = new HashSet[]{new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9),
                new HashSet<>(9), new HashSet<>(9), new HashSet<>(9)};
        int number;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] - '0' > 9 || board[i][j] - '0' < 0) {
                    break; // 非数字，直接跳过
                }
                number = board[i][j] - '0';
                if (lineSet[i].contains(number))
                    return false;
                lineSet[i].add(number);
                if (rowSet[j].contains(number))
                    return false;
                rowSet[j].add(number);
                int squarePosition = (j / 3) * 3 + (i / 3);
                if (squareSet[squarePosition].contains(number))
                    return false;
                squareSet[squarePosition].add(number);
            }
        }
        return true;
    }
}
