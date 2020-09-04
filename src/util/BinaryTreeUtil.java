package util;

import elementary_algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeUtil {
    public static String getBinaryTreeString(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        BTreePrinter.printTreeNode(root, builder);
        return builder.toString();
    }
}

class BTreePrinter {
    /**
     * 方法参考于 http://codingdict.com/questions/3264
     */
    public static void printTreeNode(TreeNode root, StringBuilder builder) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel, builder);
    }

    private static void printTreeNodeInternal(List<TreeNode> TreeNodes, int level, int maxLevel, StringBuilder builder) {
        if (TreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces, builder);

        List<TreeNode> newTreeNodes = new ArrayList<TreeNode>();
        for (TreeNode TreeNode : TreeNodes) {
            if (TreeNode != null) {
                builder.append(TreeNode.getVal());
                newTreeNodes.add(TreeNode.getLeft());
                newTreeNodes.add(TreeNode.getRight());
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                builder.append(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces, builder);
        }
        builder.append("\n");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i, builder);
                if (TreeNodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1, builder);
                    continue;
                }

                if (TreeNodes.get(j).getLeft() != null)
                    builder.append("/");
                else
                    BTreePrinter.printWhitespaces(1, builder);

                BTreePrinter.printWhitespaces(i + i - 1, builder);

                if (TreeNodes.get(j).getRight() != null)
                    builder.append("\\");
                else
                    BTreePrinter.printWhitespaces(1, builder);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i, builder);
            }

            builder.append("\n");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel, builder);
    }

    private static void printWhitespaces(int count, StringBuilder builder) {
        for (int i = 0; i < count; i++)
            builder.append(" ");
    }

    private static int maxLevel(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(TreeNode.getLeft()), BTreePrinter.maxLevel(TreeNode.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
