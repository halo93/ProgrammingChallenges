package passing_car;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 1, 0, 1, 1}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int numOfPs = 0;
        int numOfPairs = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) numOfPs++;
            if (A[i] == 1) numOfPairs += numOfPs;
            if (numOfPairs > 1_000_000_000) return -1;
        }
        return numOfPairs;
        // 0, 1, 0, 1, 1
        // 0 <- 1
        // 0 <- 1 0 ->
        // 0 <- 1 0 ->
        //   <-       <- 1
    }
}
