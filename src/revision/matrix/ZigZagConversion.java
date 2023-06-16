package revision.matrix;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    private static String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        if (numRows == 1) return s;
        int[][] grid = new int[numRows][2];
        int diff = 2 * numRows - 2;
        int tmp = 0;
        for (int i = 0; i < numRows; ++i) {
            grid[i][0] = diff - tmp;
            grid[i][1] = tmp;
            tmp += 2;
        }
        grid[0][1] = diff;
        grid[numRows - 1][0] = grid[numRows - 1][1];

        int k = 0;
        for (int i = 0, j = 0; i < numRows; ++i) {
            k = i;
            while (k < s.length()) {
                res.append(s.charAt(k));
                j = j == 0 ? 1: 0;
                k += grid[i][j];
            }
            j = 1;
        }
        return res.toString();
    }
}
