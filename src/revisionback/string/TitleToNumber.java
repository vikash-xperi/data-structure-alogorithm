package revisionback.string;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    private static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans += Math.pow(26, n - i) * (columnTitle.charAt(i - 1) - 64);
        }
        return ans;
    }
}
