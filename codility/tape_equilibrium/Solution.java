package tape_equilibrium;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,4,3}));
    }

    public static int badSolution(int[] A) {
        // Implement your solution here
        int p = 1;
        int minimalAbsDiff = Integer.MAX_VALUE;
        while (p < A.length) {
            int firstSum = 0;
            int secondSum = 0;
            for (int i = 0; i < p; i++) {
                firstSum += A[i];
            }
            for (int i = p; i < A.length; i++) {
                secondSum += A[i];
            }
            int absSum = Math.abs(firstSum - secondSum);
            if (minimalAbsDiff > absSum) {
                minimalAbsDiff = absSum;
            }
            p++;
        }
        return minimalAbsDiff;
    }

    public static int solution(int[] A) {
        // Implement your solution here
        long minimalAbsDiff = Integer.MAX_VALUE;
        long sumRight = 0;
        long sumLeft = 0;
        for (int j : A) {
            sumRight += j;
        }
        for (int i = 0; i < A.length - 1; i++) {
            sumLeft += A[i];
            sumRight -= A[i];
            long abs = Math.abs(sumLeft - sumRight);
            if (minimalAbsDiff > abs) {
                minimalAbsDiff = abs;
            }
        }
        return (int) minimalAbsDiff;
    }
}
