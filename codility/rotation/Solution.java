package rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{3, 8, 9, 7, 6}, 3);
        for (var integer:
             solution) {
            System.out.println(integer);
        }
    }

    public static int[] solution(int[] A, int K) {
        // Implement your solution here
        List<Integer> ints = IntStream.of(A).boxed().collect(Collectors.toList());
        if (ints.stream().allMatch(e -> e == 0)) {
            return A;
        }

        // [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
        while (K >= 1) {
             for (int i = 0; i < A.length; i++) {
                if (i != A.length - 1) {
                    A[i + 1] = ints.get(i);
                } else {
                    A[A.length - i - 1] = ints.get(A.length - 1);
                }
            }
             ints = IntStream.of(A).boxed().collect(Collectors.toList());
            K--;
        }
        return A;
    }
}
