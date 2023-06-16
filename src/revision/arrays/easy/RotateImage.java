package revision.arrays.easy;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            reverse(matrix, i);
        }
    }

    private static void reverse(int[][] matrix, int row) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int tmp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = tmp;
            start++;
            end--;
        }
    }
}
