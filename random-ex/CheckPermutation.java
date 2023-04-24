import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("abbd", "bdba"));
        System.out.println(checkPermutation("abbde", "bdbab"));
    }

    // abbd - bdba -> true
    // bacd - bcbe -> false
    public static boolean checkPermutation(String a, String b) {
        int sumA = 0;
        int sumB = 0;
        for (char c : a.toCharArray()) {
            sumA += c;
        }
        for (char c : b.toCharArray()) {
            sumB += c;
        }
        return sumA == sumB;
    }
}
