package util;

import elementary_algorithm.linked_list.ListNode;
import elementary_algorithm.tree.TreeNode;

public class CommonUtils {
    public static String array2String(int[] array, int length) {
        if (array == null)
            return "NULL";
        int finalLength = Math.min(length, array.length);
        if (finalLength == 1)
            return "{" + array[0] + "}";
        StringBuilder builder = new StringBuilder("{");
        builder.append(array[0]);
        for (int i = 1; i < finalLength; i++) {
            builder.append(", ");
            builder.append(array[i]);
        }
        builder.append("}");
        return builder.toString();
    }

    public static String array2String(int[] array) {
        return array2String(array, array != null ? array.length : 0);
    }

    public static String array2String(int[][] array) {
        StringBuilder builder = new StringBuilder("{");
        for (int[] ints : array) {
            builder.append(array2String(ints, ints != null ? ints.length : 0));
            builder.append(", \n");
        }
        builder.append("}");
        return builder.toString();
    }

    public static String array2String(char[] array, int length) {
        if (array == null)
            return "NULL";
        int finalLength = Math.min(length, array.length);
        if (finalLength == 1)
            return "{" + array[0] + "}";
        StringBuilder builder = new StringBuilder("{");
        builder.append(array[0]);
        for (int i = 1; i < finalLength; i++) {
            builder.append(", ");
            builder.append(array[i]);
        }
        builder.append("}");
        return builder.toString();
    }

    public static String array2String(char[] array) {
        return array2String(array, array != null ? array.length : 0);
    }

    public static String array2String(char[][] array) {
        StringBuilder builder = new StringBuilder("{");
        for (char[] chars : array) {
            builder.append(array2String(chars, chars != null ? chars.length : 0));
            builder.append(", \n");
        }
        builder.append("}");
        return builder.toString();
    }

    public static String array2String(String[] array, int length) {
        if (array == null)
            return "NULL";
        int finalLength = Math.min(length, array.length);
        if (finalLength == 1)
            return "{" + array[0] + "}";
        StringBuilder builder = new StringBuilder("{");
        builder.append(array[0]);
        for (int i = 1; i < finalLength; i++) {
            builder.append(", ");
            builder.append(array[i]);
        }
        builder.append("}");
        return builder.toString();
    }

    public static String array2String(String[] array) {
        return array2String(array, array != null ? array.length : 0);
    }

    public static String array2String(String[][] array) {
        StringBuilder builder = new StringBuilder("{");
        for (String[] strings : array) {
            builder.append(array2String(strings, strings != null ? strings.length : 0));
            builder.append(", \n");
        }
        builder.append("}");
        return builder.toString();
    }

    public static String linkedList2String(ListNode root) {
        if (root == null) {
            return "null_list";
        }
        StringBuilder builder = new StringBuilder("[");
        while (root != null) {
            builder.append(root.val);
            builder.append("->");
            root = root.next;
        }
        if (builder.lastIndexOf("->") == builder.length() - 2) {
            builder.delete(builder.length() - 2, builder.length());
        }
        builder.append("]");
        return builder.toString();
    }

    public static String binaryTree2String(TreeNode root) {
        if (root == null) {
            return "null_tree";
        }
        return BinaryTreeUtil.getBinaryTreeString(root);
    }
}
