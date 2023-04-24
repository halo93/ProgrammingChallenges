import java.util.*;

public class PalindromePermutation {

    public static final int Z_NUMERIC_VALUE = Character.getNumericValue('z');
    public static final int A_NUMERIC_VALUE = Character.getNumericValue('a');

    public static void main(String[] args) {
        System.out.println(checkPalindromePermutation2("Tact Coa"));
        System.out.println(checkPalindromePermutation2("abb"));
    }

    // Tact Coa -> True: taco cat, atco eta <- 2t 2a 2c 1o
    public static boolean checkPalindromPermutation(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (c != ' ') {
                if (charCounts.containsKey(c)) {
                    charCounts.replace(c, charCounts.get(c) + 1);
                } else {
                    charCounts.put(c, 1);
                }
            }
        }
        return charCounts.entrySet().stream().filter(e -> e.getValue() % 2 != 0).count() <= 1;
    }

    public static boolean checkPalindromePermutation2(String phrase) {
        int countOdd = 0;
        int[] charTable = new int[Z_NUMERIC_VALUE - A_NUMERIC_VALUE + 1];
        for (char c : phrase.toCharArray()) {
            int charPosition = getCharPosition(c);
            if (charPosition != -1) {
                charTable[charPosition]++;
                if (charTable[charPosition] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int getCharPosition(char c) {
        int cNumericValue = Character.getNumericValue(c);
        if (A_NUMERIC_VALUE <= cNumericValue && cNumericValue <= Z_NUMERIC_VALUE) {
            return Z_NUMERIC_VALUE - cNumericValue;
        }
        return -1;
    }
}
