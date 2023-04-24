package fish;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {0,1,0,0,0}));
        System.out.println(solution(new int[] {3,2,1,5}, new int[] {1,1,0,0}));
    }

    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        // 4 3 2 6 5
        // 0 1 0 1 0
        // B[i] == 1 => queue(A[i])
        // B[i] == 0 => if queue is not empty: queue.pollAll < A[i] => queue(A[i])
        // return queue.size
        int numberOfFishes = A.length;
        if (numberOfFishes == 0) {
            return 0;
        }
        // 4 3 2 1 5
        // 0 1 0 0 0
        ArrayDeque<Integer> downstreams = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                downstreams.push(A[i]);
            } else {
                while (!downstreams.isEmpty()) {
                    if (downstreams.peek() > A[i]) {
                        numberOfFishes--;
                        break;
                    } else {
                        numberOfFishes--;
                        downstreams.pop();
                    }
                }
            }
        }
        return numberOfFishes;
    }


}
