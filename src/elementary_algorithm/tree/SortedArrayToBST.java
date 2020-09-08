package elementary_algorithm.tree;

import util.CommonUtils;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,5,6,8,15,52,666};
        SortedArrayToBST entity = new SortedArrayToBST();
        System.out.println("tree is : \n" + CommonUtils.array2String(array) + " and sortedArrayToBST = " + CommonUtils.binaryTree2String(entity.sortedArrayToBST(array)));

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int middleIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[middleIndex]);
        sortedArrayToBST(root, nums, 0, nums.length, middleIndex);
        return root;
    }

    public void sortedArrayToBST(TreeNode root, int[] nums, int start, int end, int middle) {
//        if (root == null) { // 输入控制不为null
//            return;
//        }
        if (start >= end -1) {
            return;
        }
        if (start < middle) {
            int leftMiddle = (middle - start) / 2 + start;
            root.left = new TreeNode(nums[leftMiddle]);
            sortedArrayToBST(root.left, nums, start, middle, leftMiddle);
        }
        if (middle + 1 < end) {
            int rightMiddle = (end - (middle + 1)) / 2 + middle + 1;
            root.right = new TreeNode(nums[rightMiddle]);
            sortedArrayToBST(root.right, nums, middle + 1, end, rightMiddle);
        }
    }
}
