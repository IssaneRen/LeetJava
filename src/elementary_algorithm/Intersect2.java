package elementary_algorithm;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Intersect2 {
    public static void main(String[] args) {
        int[] numArray1 = {4,9,5};
        int[] numArray2 = {9,4,9,8,4};
        System.out.println("{result: " + CommonUtils.array2String(intersect(numArray1, numArray2)) + "};");

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length == 1) {
            return Arrays.binarySearch(nums2, nums1[0]) > -1 ? nums1 : new int[0];
        }
        if (nums2.length == 1) {
            return Arrays.binarySearch(nums1, nums2[0]) > -1 ? nums2 : new int[0];
        }
        int cursor1 = 0, cursor2 = 0, cursorResult = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        while (cursor1 <= nums1.length - 1 && cursor2 <= nums2.length - 1) {
            if (nums1[cursor1] < nums2[cursor2]) {
                cursor1++;
                continue;
            } else if (nums1[cursor1] > nums2[cursor2]) {
                cursor2++;
                continue;
            }
            result[cursorResult++] = nums1[cursor1++];
            cursor2++;
        }
        return Arrays.copyOf(result, cursorResult);
    }
}
