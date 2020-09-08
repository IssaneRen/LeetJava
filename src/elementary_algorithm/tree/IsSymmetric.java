package elementary_algorithm.tree;

import util.CommonUtils;

/**
 * 对称二叉树
 * <p>
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        IsSymmetric entity = new IsSymmetric();
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) + "\n and isSymmetric = " + entity.isSymmetric1(root));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        if (root.left == null ^ root.right == null) return false; // 若一个为空一个不为空 返回false
        if (root.left != null) {  //&& root.right != null) { 工程上应该有这一半，但是前面异或已经判断好了
            return isSymmetricLoop(root.left, root.right);
        }
        return true;
    }

    public boolean isSymmetricLoop(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) return false; // 若一个为空一个不为空 返回false

        if (left != null) {  //&& root.right != null) { 工程上应该有这一半，但是前面异或已经判断好了
            if (left.val != right.val) {
                return false;
            }
            return isSymmetricLoop(left.left, right.right) && isSymmetricLoop(left.right, right.left);
        }
        return true;
    }
}
