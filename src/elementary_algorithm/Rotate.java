package elementary_algorithm;

import util.CommonUtils;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rotate {
    public static void main(String[] args) {

        int[][] array = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(array);
        System.out.println("{result: \n" + CommonUtils.array2String(array) + "};");
    }

    public static void rotate(int[][] matrix) {
//        if (matrix == null || matrix.length != matrix[0].length) {
//            return;  // illegal
//        }
//        int n = matrix.length;
        /**
         * 点 (a,b) 绕 (n,n)点 顺时针旋转 90°， 180°， 270° 的坐标分别如下：
         * (b,2n - a) (2n-a, 2n-b)  (2n-b, a)
         */
        int length = matrix.length, tmp1, tmp2;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < matrix.length - 2 - i; j++) {
                tmp1 = matrix[j][length-1-i];
                matrix[j][length-1-i] = matrix[i][j];
                tmp2 = matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j] = tmp1;
                tmp1 = matrix[length-1-j][i];
                matrix[length-1-j][i] = tmp2;
                matrix[i][j] = tmp1;
            }
        }
    }
}
