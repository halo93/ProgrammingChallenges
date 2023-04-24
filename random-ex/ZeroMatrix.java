import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,3,3,3},{1,1,1,1},{2,0,2,0}};
//        System.out.println(Arrays.deepToString(setZeroMatrix(matrix)));
        System.out.println(Arrays.deepToString(setZeroMatrixBetter(matrix)));
    }

    // 3 3 3 3     3 0 3 3
    // 1 0 1 1 ->  0 0 0 0
    // 2 2 2 0     0 0 0 0

    // 3 3 3 3     3 0 3 3
    // 1 0 1 1 ->  0 0 0 0
    // 2 2 2 2     2 0 2 2

    // 3 3 3 3 -> 2/2 = 1
    // 1 0 1 2

    // 3 3 3 3
    public static int[][] setZeroMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentElement = matrix[i][j];
                if (currentElement == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++){
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col.length; i++){
            if (col[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }

    // 3 3 3 3     3 0 3 0
    // 1 1 1 1 ->  1 0 1 0
    // 2 0 2 0     0 0 0 0
    public static int[][] setZeroMatrixBetter(int[][] matrix) {
        int numberOfRows = matrix.length;
        int numberOfCols = matrix[0].length;
        boolean isFirstRowHasZero = false;
        boolean isFirstColHasZero = false;
        for (int row = 0; row < numberOfRows; row++) {
            if (matrix[row][0] == 0) {
                isFirstColHasZero = true;
                break;
            }
        }
        for (int col = 0; col < numberOfCols; col++) {
            if (matrix[0][col] == 0) {
                isFirstRowHasZero = true;
                break;
            }
        }

        for (int row = 1; row < numberOfRows; row++) {
            for (int col = 1; col < numberOfCols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < numberOfRows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < numberOfCols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // 3 0 3 0     3 0 3 0
        // 1 0 1 1 ->  1 0 1 0
        // 0 0 0 0     0 0 0 0
        for (int col = 1; col < numberOfCols; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < numberOfRows; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (isFirstColHasZero) {
            for (int row = 0; row < numberOfRows; row++) {
                matrix[row][0] = 0;
            }
        }
        if (isFirstRowHasZero) {
            for (int col = 0; col < numberOfCols; col++) {
                matrix[0][col] = 0;
            }
        }

        return matrix;
    }
}
