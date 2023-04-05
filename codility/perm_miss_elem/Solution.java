package perm_miss_elem;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(anotherSolution(new int[] {1,3,2,4,5}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int[] A1 = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            A1[i] = A[i];
        }

        int temp = 0;
        for (int i = 0; i < A1.length; i++) {
            if (temp + 1 != A1[i]) {
                temp += 1;
                return temp;
            }
            temp = A1[i];
        }
        return temp;
    }

    public static int anotherSolution(int[] A) {
        // (1 + n)n/2 = sum =>
        int n = A.length + 1;
        long expectedSum = (1L + n) * n / 2;
        long actualSum = 0;
        for (int e : A) {
            actualSum += e;
        }
        return (int) (expectedSum - actualSum);
    }
}
