import java.util.Arrays;

public class IsUnique {

    public static void main(String[] args) {
//        System.out.println(isUnique("aaabcdeb"));
        System.out.println(isUniqueNoOtherDataStructure("aaabcdeb"));
        System.out.println(isUniqueNoOtherDataStructure("baefglom"));
    }

    // aaabcdeb -> false
    // abcdef -> true
    // No additional data structures
    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        int[] letterOccurence = new int[128];
        for (int i = 0; i < str.length(); i++) {
            int occurence = letterOccurence[str.charAt(i)];
            if (occurence >= 1) {
                return false;
            }
            letterOccurence[str.charAt(i)] = 1;
        }
        return true;
    }

    // 65 63 61
    // 0
    public static boolean isUniqueNoOtherDataStructure(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
