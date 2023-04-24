package num_disc_intersect;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution(new int[] {1,5,2,1,4,0}));
        System.out.println(solution1(new int[] {1,5,2,1,4,0}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        long[][] ranges = new long[A.length][2];
        for (int i = 0; i < A.length; i++) {
            ranges[i][0] = i - (long) A[i];
            ranges[i][1] = i + (long) A[i];
        }
        int rs = 0;
        for (int i = 0; i < ranges.length - 1; i++) {
            long currentLowerBound = ranges[i][0];
            long currentUpperBound = ranges[i][1];
            for (int j = i + 1; j < ranges.length; j++) {
                long currentLowerBoundToCompare = ranges[j][0];
                long currentUpperBoundToCompare = ranges[j][1];
                if (currentLowerBound == currentLowerBoundToCompare || currentUpperBound == currentUpperBoundToCompare
                        || currentUpperBound == currentLowerBoundToCompare || currentLowerBound == currentUpperBoundToCompare
                        || (currentLowerBound > currentLowerBoundToCompare && currentUpperBound < currentUpperBoundToCompare)
                        || (currentLowerBound < currentLowerBoundToCompare && currentUpperBound > currentUpperBoundToCompare)
                        || (currentLowerBound < currentLowerBoundToCompare && currentUpperBound > currentLowerBoundToCompare)
                        || (currentLowerBound < currentUpperBoundToCompare && currentUpperBound > currentUpperBoundToCompare)) {
                    rs++;
                }
            }

        }
        return rs;
    }

    public static int solution1(int[] A) {
        int j = 0;
        Pair[] arr = new Pair[A.length * 2];
        for (int i = 0; i < A.length; i++) {
            Pair s = new Pair(i - A[i], true);
            arr[j] = s;
            j++;
            Pair e = new Pair(i + A[i], false);
            arr[j] = e;
            j++;
        }
        Arrays.sort(arr, new Pair(0, true));
        System.out.println(Arrays.toString(arr));
        return 1;
    }

    static private class Pair implements Comparator<Pair> {
        private long x;
        private boolean start;
        public Pair(long x, boolean start) {
            this.x = x;
            this.start = start;
        }

        public int compare(Pair p1, Pair p2) {
            if (p1.x < p2.x) {
                return -1;
            } else if (p1.x > p2.x) {
                return 1;
            } else {
                if (p1.start && p2.start == false) {
                    return -1;
                } else if (p1.start == false && p2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public String toString() {
            return String.format("x: %s, start: %s\n", x, start);
        }
    }
}
