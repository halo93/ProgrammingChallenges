package max_counters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(badSolution(5, new int[]{3,4,4,6,1,4,4})));
        System.out.println(Arrays.toString(solution(5, new int[]{3,4,4,6,1,4,4})));
    }

    /**
     * 1 <= A[i] <= N*
     * 0, 0, 0, 0, 0
     *         X = 3 => 0, 0, 1, 0, 0
     *         X = 4 => 0, 0, 1, 1, 0
     *         X = 4 => 0, 0, 1, 2, 0
     *         X = 6 => 2, 2, 2, 2, 2 <= 6 = N + 1
     *         X = 1 => 3, 2, 2, 2, 2
     */
    public static int[] badSolution(int N, int[] A) {
        // Implement your solution here
        List<Integer> counters = new ArrayList<>();
        List<Integer> finalCounters = counters;
        IntStream.range(0, N).forEach(e -> finalCounters.add(0));
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                Integer max = Collections.max(counters);
                counters = counters.stream().map(e -> max).collect(Collectors.toList());
            } else if (1 <= A[i] || A[i] <= N) {
                counters.set(A[i] - 1, counters.get(A[i] - 1) + 1);
            }
        }
        return counters.stream().mapToInt(e -> e).toArray();
    }

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastUpdate = 0;
        for (int x : A) {
            if (x >= 1 && x <= N) {
                int pos = x - 1;
                if (counters[pos] < lastUpdate) {
                    counters[pos] = lastUpdate + 1;
                } else {
                    counters[pos]++;
                }
                if (counters[pos] > maxCounter) {
                    maxCounter = counters[pos];
                }
            } else if (x == N + 1) {
                lastUpdate = maxCounter;
            }
        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }
        }
        return counters;
    }
}
