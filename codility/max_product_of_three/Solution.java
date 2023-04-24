package max_product_of_three;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(badSolution(new int[] {-3, 1, 2, -2, 5, 6}));
        System.out.println(badSolution(new int[] {-1000, -1, -500, -2, 3, 5, 6}));
        System.out.println(badSolution(new int[] {-1000, -500, -200, -2, -3}));
        System.out.println(solution(new int[] {-3, 1, 2, -2, 5, 6}));
        System.out.println(solution(new int[] {-1000, -1, -500, -2, 3, 5, 6}));
        System.out.println(solution(new int[] {-1000, -500, -200, -2, -3}));
        System.out.println(solution1(new int[] {-3, 1, 2, -2, 5, 6}));
        System.out.println(solution1(new int[] {-1000, -1, -500, -2, 3, 5, 6}));
        System.out.println(solution1(new int[] {-1000, -500, -200, -2, -3}));
    }

    public static int badSolution(int[] A) {
        // Implement your solution here
        int n = A.length;
        if (n == 3) {
            return A[0] * A[1] * A[2];
        }
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    int product = A[i] * A[j] * A[k];
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }
        return maxProduct;
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n = A.length;
        if (n == 3) {
            return A[0] * A[1] * A[2];
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = A[i];
            } else if (A[i] > max2) {
                max3 = max2;
                max2 = A[i];
            } else if (A[i] > max3) {
                max3 = A[i];
            }
            if (A[i] < min1) {
                min2 = min1;
                min1 = A[i];
            } else if (A[i] < min2){
                min2 = A[i];
            }
        }
        int prod1 = max1 * max2 * max3;
        int prod2 = min1 * min2 * max1;

        return Math.max(prod1, prod2);
    }

    public static int solution1(int[] A) {
        // Implement your solution here
        int n = A.length;
        if (n == 3) {
            return A[0] * A[1] * A[2];
        }
        Arrays.sort(A);

        return Math.max(A[0] * A[1] * A[n-1], A[n-1] * A[n-2] * A[n-3]);
    }
}
