import java.util.HashSet;

public class FirstRecurringChar {
    public static void main(String[] args) {
        System.out.println(findFirstRecurringCharacter("ABCCD"));
        System.out.println(findFirstRecurringCharacter("abcdbef"));
        System.out.println(findFirstRecurringCharacter2("ABCCD"));
        System.out.println(findFirstRecurringCharacter2("abcdbef"));
    }

    // O(n^2)
    public static String findFirstRecurringCharacter(String str) {
        if (str.isEmpty()) {
            return "";
        }
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char lowChar = str.charAt(i);
            char highChar = str.charAt(j);
            if (lowChar != highChar) {
                j--;
                if (j == i) {
                    i++;
                    j = str.length() - 1;
                }
            } else {
                return String.valueOf(lowChar);
            }
        }
        return "";
    }

    public static String findFirstRecurringCharacter2(String str) {
        if (str.isEmpty()) {
            return "";
        }
        HashSet<Character> distinctChars = new HashSet<>();
        for (char e : str.toCharArray()) {
            if (distinctChars.contains(e)) {
                return String.valueOf(e);
            }
            distinctChars.add(e);
        }
        return "";
    }
}
