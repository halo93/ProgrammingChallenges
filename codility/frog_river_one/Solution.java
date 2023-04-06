package frog_river_one;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {1,3,1,4,2,3,5,4}));
        System.out.println(solution(5, new int[] {1,3,1,4,2,3,4,4}));
        System.out.println(solution(5, new int[] {5}));
    }

    public static int solution(int X, int[] A) {
        // Implement your solution here
        Set<Integer> requiredLeavePositions = new HashSet<>();
        IntStream.rangeClosed(1, X).forEach(requiredLeavePositions::add);
        Set<Integer> currentLeavePositions = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            currentLeavePositions.add(A[i]);
            if (currentLeavePositions.size() < requiredLeavePositions.size()) continue;
            if (requiredLeavePositions.containsAll(currentLeavePositions)) {
                return i;
            }
        }
        return -1;
    }
}
