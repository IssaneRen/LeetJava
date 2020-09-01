package util;

public class CommonUtils {
    public static String  array2String(int[] array, int length) {
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
    public static String  array2String(int[] array) {
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
}
