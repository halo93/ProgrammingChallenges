package perm_check;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution(new int[] {4,1,3}));
        System.out.println(solution(new int[] {4,1,3,2}));
        System.out.println(solution(new int[] {9, 5, 7, 3, 2, 7, 3, 1, 10, 8}));
//        System.out.println(solution(new int[] {4}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        if (A[0] != 1 || A[A.length - 1] != A.length) {
            return 0;
        }
        long requiredSum = IntStream.rangeClosed(A[0], A[A.length - 1]).sum();
        long actualSum = Arrays.stream(A).distinct().sum();
        return requiredSum == actualSum ? 1 : 0;
    }
}
