package intermediate_algorithm.rank_and_search;

import java.util.Arrays;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * 相关标签
 * 数组
 * 二分查找
 * 分治
 * 矩阵
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvc64r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SearchMatrix {

    public static void main(String[] args) {
//        int[] row1 = new int[]{1, 4, 7, 11, 15};
//        int[] row2 = new int[]{2, 5, 8, 12, 19};
//        int[] row3 = new int[]{3, 6, 9, 16, 22};
//        int[] row4 = new int[]{10, 13, 14, 17, 24};
//        int[] row5 = new int[]{18, 21, 23, 26, 30};
//        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};

//        int[] row1 = new int[]{1    ,4  ,7  ,11 ,15};
//        int[] row2 = new int[]{2    ,5  ,8  ,12 ,19};
//        int[] row3 = new int[]{3    ,6  ,9  ,16 ,22};
//        int[] row4 = new int[]{10   ,13 ,14 ,17 ,24};
//        int[] row5 = new int[]{18   ,21 ,23 ,26 ,30};
//        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};
//        int target = 5;

//        int[][] matrix = new int[][]{{1,3,5}};
//        int target = 5;

//        int[] row1 = new int[]{1    ,2  ,3  ,4 ,5};
//        int[] row2 = new int[]{6,7,8,9,10};
//        int[] row3 = new int[]{11,12,13,14,15};
//        int[] row4 = new int[]{16,17,18,19,20};
//        int[] row5 = new int[]{21,22,23,24,25};
//        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};
//        int target = 1;

        int[] row1 = new int[]{1, 4, 7, 11, 15};
        int[] row2 = new int[]{2, 5, 8, 12, 19};
        int[] row3 = new int[]{3, 6, 9, 16, 22};
        int[] row4 = new int[]{10, 13, 14, 17, 24};
        int[] row5 = new int[]{18, 21, 23, 26, 30};
        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};
        int target = 5;

        System.out.println("SearchMatrix, 结果=" + (new SearchMatrix()).searchMatrix3(matrix, target));
    }

    /**
     * 第一次尝试，读到题因为是排好序的，所以肯定是二分，但是有两个维度，所以我们要先找到对应的行，再找到对应的位置
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 0. 容错，保证Matrix没有空及不能长度为0 （刷题的时候应该可以隐藏）
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        // 1. 先找行
        int rowIndexStart = 0, rowIndexEnd = matrix.length - 1, middle = rowIndexEnd / 2, tmp;
        while (rowIndexStart < rowIndexEnd) {
            tmp = matrix[middle][0];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                if (middle <= 0) return false;
                tmp = matrix[middle - 1][0];
                if (tmp == target) return true;
                else if (tmp < target) return searchMatrixRow(matrix[middle - 1], target);
                else {
                    rowIndexEnd = middle - 2;
                    middle = (rowIndexStart + rowIndexEnd) / 2;
                }
            } else {
                if (middle >= rowIndexEnd) return false;
                tmp = matrix[middle + 1][0];
                if (tmp == target) return true;
                else if (tmp > target) return searchMatrixRow(matrix[middle], target);
                else {
                    rowIndexStart = middle + 2;
                    middle = (rowIndexStart + rowIndexEnd) / 2;
                }

            }
        }
        return false;
    }

    private boolean searchMatrixRow(int[] matrixRow, int target) {
        return Arrays.binarySearch(matrixRow, target) >= 0;
    }

    /**
     * 尝试2 上一次仍有异常，异常数据：
     * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
     * 5
     * <p>
     * 反思了一下，每一行不见得都比下一行小，所以不能单纯的排除一整行 还是要整体判断xy
     * <p>
     * 画了一下图，每当找到一左一右比target更大或者更小的两块，所以想到递归分治
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
//        // 0. 容错，保证Matrix没有空及不能长度为0 （刷题的时候应该可以隐藏）
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        // 1. 先从中间行middle开始找，这个不变，而且条件已知n>=1 所以我们直接取一个固定的中间
        return recurseSearch2(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    /**
     * @param endX X代表第一维度了，横竖就先不管了
     */
    private boolean recurseSearch2(final int[][] matrix, final int startX, final int startY, final int endX, final int endY, int target) {
        // 1. 如果判断到了长或宽只有四个格子，直接遍历（因为按照通用逻辑循环的话，复杂度差不多）
        if ((endX - startX) <= 1 && (endY - startY) <= 1) {
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
            return false;
        }
        // 2. 如果某一维度，只剩下一行了。 则直接二分查找
        if (endX == startX) {
            return Arrays.binarySearch(Arrays.copyOfRange(matrix[endX], startY, endY + 1), target) >= 0;
        }
        if (endY == startY) {
            int[] res = new int[endX - startX + 1];
            for (int i = 0; i <= endX - startX; i++) {
                res[i] = matrix[startX + i][endY];
            }
            return Arrays.binarySearch(res, target) >= 0;
        }

        // 3. 不是特殊情况，正常递归
        final int middleX = (startX + endX) / 2;
        int yIndexStart = startY, yIndexEnd = endY, middle = (yIndexStart + yIndexEnd) / 2;
        while (yIndexStart < yIndexEnd - 1) {
            if (matrix[middleX][middle] == target) {
                return true;
            } else if (matrix[middleX][middle] > target) {
                yIndexEnd = middle;
            } else {
                yIndexStart = middle;
            }
            middle = (yIndexStart + yIndexEnd) / 2;
        }
        if (matrix[middleX][yIndexStart] == target || matrix[middleX][yIndexEnd] == target) return true;
        if (matrix[middleX][yIndexStart] < target && matrix[middleX][yIndexEnd] > target) {
            return ( middle > 0 && recurseSearch2(matrix, startX, yIndexEnd, middleX - 1, endY, target))
                    || recurseSearch2(matrix, middleX + 1, startY, endX, yIndexStart, target);
        } else if (matrix[middleX][yIndexStart] > target)
            return middleX > 0 && recurseSearch2(matrix, startX, startY, middleX - 1, endY, target);
        else if (matrix[middleX][yIndexEnd] < target)
            return recurseSearch2(matrix, middleX + 1, startY, endX, endY, target);
        return false;
    }

    /**
     * 第二次又错了。错误的数据 [[1,3,5]]
     * 5
     * 检查之后是 Arrays.binarySearch( 中的end参数需要是end+1 得是不访问的那个
     * 第三次改了又错了 错误的数据：[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
     * 1
     *
     * 第四次多了一步判断，在跳出循环开始递归之前，检查一下是否找到了
     * 但是第五次提交又错了
     * 异常提交：[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
     * 5
     *
     * 最后还是看了一下答案。。+
     * 方法三：Z 字形查找
     * 思路与算法
     *
     * 我们可以从矩阵 matrix 的右上角 (0, n-1)进行搜索。在每一步的搜索过程中，如果我们位于位置 (x, y)，那么我们希望在以 matrix 的左下角为左下角、以 (x, y)(x,y) 为右上角的矩阵中进行搜索，即行的范围为 [x, m - 1][x,m−1]，列的范围为 [0, y][0,y]：
     *
     * 如果 matrix[x, y] = target，说明搜索完成；
     *
     * 如果 matrix[x, y] > target，由于每一列的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第 y 列的元素都是严格大于 target 的，因此我们可以将它们全部忽略，即将 y 减少 1；
     *
     * 如果 matrix[x, y] <target，由于每一行的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第 x 行的元素都是严格小于 target 的，因此我们可以将它们全部忽略，即将 x 增加 1。
     *
     * 在搜索的过程中，如果我们超出了矩阵的边界，那么说明矩阵中不存在 target。
     *
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int p = 0, q = matrix[0].length - 1;
        while (p < matrix.length && q >= 0) {
            if (matrix[p][q] > target) q--;
            else if (matrix[p][q] < target) p++;
            else return true;
        }
        return false;
    }
}
