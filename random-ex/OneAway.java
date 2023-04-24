public class OneAway {

    public static void main(String[] args) {
        String a = "ong";
        String b = "long";
        boolean isOneEdit = oneEditAway2(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }

    public static boolean oneEditAway(String first, String second) {
        // a.length == b.length - 1 => Insert
        // a.length > b.length => Insert
        // a.length == b.length + 1 => Replace
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() == second.length() - 1) {
            return onedEditInsert(first, second);
        } else if (first.length() == second.length() + 1) {
            return onedEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    // long, lon -> true
    // ong, long
    private static boolean onedEditInsert(String toBeInsertedStr, String completedStr) {
        int i = 0;
        int j = 0;
        while (i < toBeInsertedStr.length() && j < completedStr.length()) {
            char c1 = toBeInsertedStr.charAt(i);
            char c2 = completedStr.charAt(j);
            if (c1 != c2) {
                if (i != j) {
                    return false;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }


    public static boolean oneEditAway2(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        // ong
        // long
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }
}
