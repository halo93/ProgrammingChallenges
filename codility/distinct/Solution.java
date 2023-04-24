package distinct;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,1,2,3,1}));
        System.out.println(anotherSolution(new int[]{2,1,1,2,3,1}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 0;
        }
        return Arrays.stream(A).boxed().collect(Collectors.toSet()).size();
    }

    public static int anotherSolution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int rs = 1;
        int currNumb = A[0];
        for (int e : A) {
            if (e != currNumb) {
                rs++;
                currNumb = e;
            }
        }
        return rs;
    }

}
