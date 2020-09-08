package elementary_algorithm.tree;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 *
 * 重新做题
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        LevelOrder entity = new LevelOrder();
        System.out.println("tree is : \n" + CommonUtils.binaryTree2String(root) + "\n and levelOrder = " + entity.levelOrder(root).toString());
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
//        List<Integer> firstLayer = new ArrayList<>();
//        firstLayer.add(root.val);
        List<List<Integer>> allLayers = new ArrayList<>();
//        allLayers.add(firstLayer);
        addLevelIntoList(root, allLayers, 0);
        return allLayers;
    }

    public void addLevelIntoList(TreeNode root, List<List<Integer>> list, int layerIndex) {
        if (root == null) {
            return;
        }
        List<Integer> currentLayer;
        if (list.size() <= layerIndex) {
            currentLayer = new ArrayList<>();
            list.add(currentLayer);
        } else {
            currentLayer = list.get(layerIndex);
        }
        currentLayer.add(root.val);

        addLevelIntoList(root.left, list, layerIndex + 1);
        addLevelIntoList(root.right, list, layerIndex + 1);
    }
}
