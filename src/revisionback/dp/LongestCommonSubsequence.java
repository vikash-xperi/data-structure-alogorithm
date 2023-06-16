package revisionback.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs("ABCAB", "AECB"));
        String s1 = "ABCAB", s2 = "AECB";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcs(s1.length(), s2.length(), s1, s2, dp));
        System.out.println(lcsTabulation(s1, s2));
        System.out.println(lcsTabulationSpaceOptimized(s1, s2));
    }

    private static String lcs(String s1, String s2) {
        if (s1.equals("") || s2.equals("")) return "";
        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1))
            return lcs(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + s1.charAt(s1.length() - 1);
        else {
            String str1 = lcs(s1, s2.substring(0, s2.length() - 1));
            String str2 = lcs(s1.substring(0, s1.length() - 1), s2);
            return str1.length() > str2.length() ? str1 : str2;
        }
    }

    private static int lcs(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = lcs(m - 1, n - 1, s1, s2, dp) + 1;
        } else {
            dp[m][n] = Math.max(lcs(m, n - 1, s1, s2, dp), lcs(m - 1, n, s1, s2, dp));
        }
        return dp[m][n];
    }

    private static int lcsTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int ans = dp[s1.length()][s2.length()];
        char[] arr = new char[ans];

        int r = s1.length(), c = s2.length();
        for (int i = arr.length - 1; i >= 0;) {
            int tmp = dp[r][c];
            if (tmp != dp[r - 1][c] && tmp != dp[r][c - 1]) {
                arr[i] = s1.charAt(r - 1);
                r = r - 1;
                c = c - 1;
                i--;
            }
            else if (tmp == dp[r - 1][c]) r = r - 1;
            else if (tmp == dp[r][c - 1]) c = c - 1;
        }

        System.out.println(Arrays.toString(arr));

        return dp[s1.length()][s2.length()];
    }

    private static int lcsTabulationSpaceOptimized(String s1, String s2) {
        int[] a = new int[s1.length() + 1];
        int[] b = new int[s1.length() + 1];
        Arrays.fill(a, 0);
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            for (int j = 1; j < b.length; j++) {
                if (ch == s1.charAt(j - 1)) {
                    b[j] = a[j - 1] + 1;
                } else {
                    b[j] = Math.max(a[j], b[j - 1]);
                }
            }
            System.arraycopy(b, 0, a, 0, b.length);
        }
        return b[s1.length()];
    }
}
