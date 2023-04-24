package triangle;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(badSolution(new int[] {10,2,5,1,8,20}));
//        System.out.println(badSolution(new int[] {10,50,5,1}));
//        System.out.println(badSolution(new int[] {5,1,8,14,12}));
//        System.out.println(badSolution(new int[] {-5,-3,1,8,14}));
        System.out.println(badSolution(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
//        System.out.println(solution(new int[] {10,2,5,1,8,20}));
//        System.out.println(solution(new int[] {10,50,5,1}));
//        System.out.println(solution(new int[] {5,1,8,14,12}));
//        System.out.println(solution(new int[] {-5,-3,1,8,14}));
        System.out.println(solution(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }

    public static int badSolution(int[] A) {
        // Implement your solution here
        for (int i = 0; i < A.length; i++) {
            int first = A[i];
            for (int j = i + 1; j < A.length; j++){
                int second = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    int third = A[k];
                    if (first + second > third && first + third > second && second + third > first) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    // 10,2,5,1,8,20 -> 1,2,5,8,10,20
    // 1,5,8,12,14
    // 10,50,5,1 -> 1,5,10,45,50
    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            long i1 = (long) A[i] + (long) A[i + 1];
            if (i1 > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }
}
