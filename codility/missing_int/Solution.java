package missing_int;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {-1,1,4,9,1}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int minMissingElement = 1;
        for (int i : A) {
            if (minMissingElement == i) {
                minMissingElement++;
            }
            if (i > minMissingElement) {
                return minMissingElement;
            }
        }
        return minMissingElement;
        // -1,2,1,4,9,1 => -1, 1, 1, 4, 9
    }

}
