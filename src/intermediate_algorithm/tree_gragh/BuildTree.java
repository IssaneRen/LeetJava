package intermediate_algorithm.tree_gragh;

import elementary_algorithm.tree.TreeNode;
import util.CommonUtils;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvix0d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] input1 = new int[]{3, 9, 20, 15, 7}, input2 = new int[]{9, 3, 15, 20, 7};
        System.out.println("{preorder: " + CommonUtils.array2String(input1) +
                "}, {inorder: " + CommonUtils.array2String(input2) +
                "}; ----> \n" + CommonUtils.binaryTree2String(new BuildTree().buildTree(input1, input2)));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // getTreeNodeCount(root) ：
        //   定义函数 getTreeNodeCount(root) = {x0, x1} --- 其中 x0 是其左子树节点数，x1 是其右子树节点数
        //   则 preorder[1 + x0 + x1]   inorder[x0 + 1 + x1]
        //   且 preorder[0] = inorder[x0 - 1] = root.val; preorder[1] = inorder[0] = root.left.val; preorder[x0] = inorder[x0] = root.right.val
        //
        // 逻辑到这里还算清晰，但是有一个问题，就是Int大概率重复，没法通过相等确定

        // 冷静了一下，记录一下思路：
        //   1. 对于preOder和 inOrder 长度相等，  设其长度为sum，  设左子树节点数为l， 右子树节点数为r。
        //       则： preOder[0~1] 为根，  preOrder[1~l+1]为左子树
        //       而： inOrder[0~l]为左子树， inOrder[l, l+1]为根
        //   2. 现在我们的关键问题是循环的终止条件。  继续往下想一下，对于左子树， preOrderL[] = preOrder[1~l+1]   inOrderL[] = inOrder[0~l]
        //      若我们再对左子树的l个节点，假设其左子树节点数为lL，右子树节点数为rL。同理得   preOrderLL[] = preOrderL[1~lL+1] = preOrder[2~lL+2]

        // -------------------------- 审题不仔细。。。。。。。。。。。。。。。。。。。。。。
        // 题目已经说了：  你可以假设树中没有重复的元素。何必这么麻烦。。。。



        if (preorder == null || preorder.length <= 0) { // || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        generate(root, preorder, 0, inorder, 0, inorder.length);

        return root;
    }

    public void generate(TreeNode currentRoot, int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        // currentRoot一定不为空
        int currentRootVal = preorder[preStart], rootIndexInInorder = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == currentRootVal) {
                rootIndexInInorder = i;
                break;
            }
        }
        int leftLength = rootIndexInInorder - inStart, rightLength = inEnd - rootIndexInInorder - 1;
        if (leftLength == 1) {
            currentRoot.left = new TreeNode(inorder[inStart]);
        } else if (leftLength > 1) {
            currentRoot.left = new TreeNode(preorder[preStart + 1]);
            generate(currentRoot.left, preorder, preStart + 1, inorder, inStart, inStart + leftLength);
        }

        if (rightLength == 1) {
            currentRoot.right = new TreeNode(inorder[rootIndexInInorder + 1]);
        } else if (rightLength > 1) {
            currentRoot.right = new TreeNode(preorder[preStart + leftLength + 1]);
            generate(currentRoot.right, preorder, preStart + leftLength + 1, inorder, rootIndexInInorder + 1, inEnd);
        }
    }
}
