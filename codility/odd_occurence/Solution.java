package odd_occurence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Map<Integer, Integer> occurences = new HashMap<>();
        occurences.put(A[0], 1);
        for (int i = 1; i < A.length; i++) {
            if (occurences.containsKey(A[i])) {
                occurences.put(A[i], occurences.get(A[i]) + 1);
            } else {
                occurences.put(A[i], 1);
            }
        }
        return occurences.entrySet().stream().filter(e -> e.getValue() % 2 != 0).map(Map.Entry::getKey).findFirst().orElse(1);
    }
}
