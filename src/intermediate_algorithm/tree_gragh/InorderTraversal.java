package intermediate_algorithm.tree_gragh;

import elementary_algorithm.tree.TreeNode;
import util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv7pir/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(21);
        root.right.left.left = new TreeNode(17);
        root.right.left.right = new TreeNode(19);
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) +
                "\n and its inorderTraversal = " + new InorderTraversal().inorderTraversal(root));
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursion(root, result);
        return result;
    }

    public void inorderTraversalRecursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversalRecursion(root.left, result);
            result.add(root.val);
            inorderTraversalRecursion(root.right, result);
        }
    }
}
