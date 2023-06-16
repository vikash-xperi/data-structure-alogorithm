package string;

public class ZigZag {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    public static String convert(String s, int numRows) {
        char[][] mat = new char[numRows][7];
        int k = 0, i = 0, j = 0;
        while (k < s.length()) {
            if (i == 0) {
                while (i < numRows - 1 && k < s.length()) {
                    mat[i++][j] = s.charAt(k++);
                }
            }
            while (i > 0 && k < s.length()) {
                mat[i--][j++] = s.charAt(k++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; ++i) {
            for (j = 0; j < 7; ++j) {
                if ((int)mat[i][j] != 0)
                    sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
}
