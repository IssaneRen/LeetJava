package elementary_algorithm.rank_and_search;

import util.CommonUtils;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Merge {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] array2 = new int[]{2, 5, 6};
        int param1 = 3, param2 = 3;

        System.out.println("This is Test log:\narray1 is : " + CommonUtils.array2String(array1) +
                " \nand array2 = " + CommonUtils.array2String(array2) + "\n param1=" + param1 + "; param2=" + param2);
        Merge entity = new Merge();
        entity.merge(array1, param1, array2, param2);
        System.out.println("merge result = " + CommonUtils.array2String(array1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
}
