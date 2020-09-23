package intermediate_algorithm.tree_gragh;

import elementary_algorithm.tree.TreeNode;
import util.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvle7s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(21);
        root.right.left.left = new TreeNode(17);
        root.right.left.right = new TreeNode(19);
        root.right.right.left = new TreeNode(111);
        root.right.right.right = new TreeNode(299);
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) +
                "\n and its zigzagLevelOrder = " + new ZigzagLevelOrder().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrderRecursion(root, result, 0);
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    public void zigzagLevelOrderRecursion(TreeNode root, List<List<Integer>> result, int currentLayer) {
        if (root == null) {
            return;
        }
        List<Integer> list = result.size() > currentLayer ? result.get(currentLayer) : null;
        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            result.add(currentLayer, list);
        }
        list.add(root.val);
        zigzagLevelOrderRecursion(root.left, result, currentLayer + 1);
        zigzagLevelOrderRecursion(root.right, result, currentLayer + 1);
//        // 当前layer是奇数
//        if (currentLayer % 2 == 1) {
//            zigzagLevelOrderRecursion(root.left, result, currentLayer + 1);
//            zigzagLevelOrderRecursion(root.right, result, currentLayer + 1);
//        } else {
//            zigzagLevelOrderRecursion(root.right, result, currentLayer + 1);
//            zigzagLevelOrderRecursion(root.left, result, currentLayer + 1);
//        }
    }
}
