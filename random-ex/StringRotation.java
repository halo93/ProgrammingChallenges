public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isSubstring("erbottlewat", "waterbottle"));
        System.out.println(isSubstring("abc", "bca")); //abcabc
    }

    /*
     * Assume you have a method isSubstring which checks if one word is a
     * substring of another. Given two strings, s1 and s2, write code to check if s2 is
     * a rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a
     * rotation of "erbottlewat").
     */
    public static boolean isSubstring(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String combination = s1 + s1;
        return combination.contains(s2);
    }
}
