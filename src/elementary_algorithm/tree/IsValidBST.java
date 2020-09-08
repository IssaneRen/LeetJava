package elementary_algorithm.tree;

import util.CommonUtils;

/**
 * 验证二叉搜索树
 * <p>
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsValidBST {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        IsValidBST entity = new IsValidBST();
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) + "\n and isValidBST = " + entity.isValidBST(root));
    }

    /**
     * 前序遍历一次，看看是否为升序
     *输入：
     * [10,5,15,null,null,6,20]
     * 输出：
     * true
     * 预期结果：
     * false
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        try {
            isValidBST(root, Long.MIN_VALUE);
        } catch (WrongTreeException e) {
            return false;
        }
        return true;
    }

    /**
     * 递归方法，每次返回当前遍历的最大数字
     * @param root 非空根节点。  为了避免逻辑复杂，非空请在调用处判断
     * @param last
     * @return
     */
    public int isValidBST(TreeNode root, long last) throws WrongTreeException {
//        if (root == null) {
//            return 0; //
//        }
        if (root.left != null) {
            last = isValidBST(root.left, last);
        }
        if (root.val <= last) {
            throw new WrongTreeException();
        }
        last = root.val;
        if (root.right != null) {
            last = isValidBST(root.right, last);
        }
        return (int)last;
    }

    private static class WrongTreeException extends Exception {

    }
}
