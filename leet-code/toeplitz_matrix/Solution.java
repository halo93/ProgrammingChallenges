package toeplitz_matrix;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int subtractionBtwRowCol = row - col;
                if (!groups.containsKey(subtractionBtwRowCol)) {
                    groups.put(subtractionBtwRowCol, matrix[row][col]);
                } else if (groups.get(subtractionBtwRowCol) != matrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
//        int[][] matrix = new int[][] {{1,2},{2,2}};
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}
