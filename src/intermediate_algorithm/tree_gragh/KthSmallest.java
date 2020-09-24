package intermediate_algorithm.tree_gragh;

import elementary_algorithm.tree.TreeNode;
import util.CommonUtils;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvuyv3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KthSmallest {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.left.right = new TreeNode(2);
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(1);
        TreeNode root = CommonUtils.arrayToTree(new Integer[]{28,12,45,4,24,35,47,2,9,14,25,31,42,46,48,0,3,8,11,13,20,null,26,30,33,41,43,null,null,null,49,null,1,null,null,7,null,10,null,null,null,17,22,null,27,29,null,32,34,36,null,null,44,null,null,null,null,6,null,null,null,16,18,21,23,null,null,null,null,null,null,null,null,null,37,null,null,5,null,15,null,null,19,null,null,null,null,null,40,null,null,null,null,null,null,39,null,38});
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) +
                "\n and its kthSmallest = " + new KthSmallest().kthSmallest(root, 12));
    }

    public int kthSmallest(TreeNode root, int k) {
//        if (root == null) {
//            return 0;  //1 ≤ k ≤ 二叉搜索树元素个数 所以不会为0
//        }
        return legalKthNode(root, k, 0).node.val;
    }

    /**
     * 通过根节点，找到合法的 第K个， 假设输入k必定合法，
     * @param root 不为null
     * @return
     */
    public TreeNodeCount legalKthNode(TreeNode root, int k, int currentLeftCount) {
        TreeNodeCount leftNodeWithCount = null;
        if (root.left != null) {
            leftNodeWithCount = legalKthNode(root.left, k, currentLeftCount);
            if (leftNodeWithCount.node != null) {
                return leftNodeWithCount;  // 如果已经找到了
            }
        }
        int[] leftArray = leftNodeWithCount != null ? leftNodeWithCount.childrenNumber : null;
        int leftNumber = (leftArray != null ? leftArray[0] + leftArray[1] + 1 : 0);
        if (leftNumber + currentLeftCount == k - 1) {
            return new TreeNodeCount(root, null);
        }

        TreeNodeCount rightNodeWithCount = null;
        if (root.right != null) {
            rightNodeWithCount = legalKthNode(root.right, k, leftNumber + 1 + currentLeftCount);
            if (rightNodeWithCount.node != null) {
                return rightNodeWithCount;  // 如果已经找到了
            }
        }
        int[] rightArray = rightNodeWithCount != null ? rightNodeWithCount.childrenNumber : null;
        int rightNumber = rightArray != null ? rightArray[0] + rightArray[1] + 1 : 0;

        return new TreeNodeCount(null, new int[]{leftNumber, rightNumber});
    }

    private static class TreeNodeCount {
        TreeNode node;
        int[] childrenNumber;

        public TreeNodeCount(TreeNode node, int[] childrenNumber) {
            this.node = node;
            this.childrenNumber = childrenNumber;
        }
    }

    public int[] getChildNumber(TreeNode treeNode) {
//        if (treeNode == null)
//            return new int[]{0, 0};
        int leftNumber = treeNode.left != null ? getChildNumber(treeNode.left)[0] + getChildNumber(treeNode.left)[1] : 0;
        int rightNumber = treeNode.right != null ? getChildNumber(treeNode.right)[0] + getChildNumber(treeNode.right)[1] : 0;
        return new int[]{leftNumber, rightNumber};
    }
}
