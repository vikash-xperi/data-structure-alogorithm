package revisionback.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int m = maxRow, n = maxCol;
        List<Integer> ans = new ArrayList<>();
        int currRow = 0, currCol = 0;
        while (ans.size() < m * n) {
            while (currCol < maxCol && ans.size() < (m * n)) {
                ans.add(matrix[currRow][currCol]);
                currCol++;
            }
            currCol = maxCol - 1;
            currRow++;
            while (currRow < maxRow && ans.size() < (m * n)) {
                ans.add(matrix[currRow][currCol]);
                currRow++;
            }
            currRow = maxRow - 1;
            currCol--;
            while (currCol >= (n - maxCol) && ans.size() < (m * n)) {
                ans.add(matrix[currRow][currCol]);
                currCol--;
            }
            currCol = n - maxCol;
            currRow--;
            while (currRow > (m - maxRow) && ans.size() < (m * n)) {
                ans.add(matrix[currRow][currCol]);
                currRow--;
            }
            currRow++;
            currCol++;
            maxCol--;
            maxRow--;
        }
        return ans;
    }
}
