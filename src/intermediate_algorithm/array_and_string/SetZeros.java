package intermediate_algorithm.array_and_string;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvmy42/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("{input: \n" + CommonUtils.array2String(matrix) + "}");
        new SetZeros().setZeroes(matrix);
        System.out.println("{output: \n" + CommonUtils.array2String(matrix) + "}");
    }

    /***
     * 原地算法比较麻烦
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int width = matrix[0].length, height = matrix.length;
        int[] record = new int[height + width]; // 前 height 个元素 记录该行是否要置0， 后width个元素表示该列是否要置为
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    record[i] = 1;
                    record[height + j] = 1;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            if (record[i] == 1) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = height; i < height + width; i++) {
            if (record[i] == 1) {
                for (int j = 0; j < height; j++) {
                    matrix[j][i - height] = 0;
                }
            }
        }
    }
}
