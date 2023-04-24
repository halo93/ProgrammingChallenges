import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,3,0,9,1,2},{9,0,3,3,4,3},{3,9,0,3,4,6},{3,9,3,0,7,8},{1,2,3,4,5,6},{7,8,9,5,3,2}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] m) {
        try {
            int rows = m.length;
            int columns = m[0].length;
            String str = "|\t";

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    str += m[i][j] + "\t";
                }
                System.out.println(str + "|");
                str = "|\t";
            }
        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }

    // 3 3 0 9     3 3 9 3
    // 9 0 3 3 ->  9 9 0 3
    // 3 9 0 3     3 0 3 0
    // 3 9 3 0     0 3 3 9
    public static boolean rotate(int[][] matrix) {
        // row, col
        //  -> m[n-1][0] ; m[0][1] -> m[n-2][0]
        // m[n-1][0] -> m[0][0]
        // m[3][3] -> m[0][3]
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int lastElementIdx = n - 1 - layer;
            for (int i = layer; i < lastElementIdx; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];
                // top = left
                matrix[layer][i] = matrix[lastElementIdx - offset][layer];
                // left = bottom
                matrix[lastElementIdx - offset][layer] = matrix[lastElementIdx][lastElementIdx - offset];
                // bottom = right
                matrix[lastElementIdx][lastElementIdx - offset] = matrix[i][lastElementIdx];
                // right = top
                matrix[i][lastElementIdx] = top;
            }
        }
        return true;
    }

}
