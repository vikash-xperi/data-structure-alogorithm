package revision.dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCAB", s2 = "AECB";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
//        System.out.print(lcs(s1.length(), s2.length(), s1, s2, dp));
        System.out.print(lcsTabularMethod(s1.length(), s2.length(), s1, s2));
    }

    public static int lcsRecursive(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + lcsRecursive(m - 1, n - 1, s1, s2, dp);
        } else {
            return dp[m][n] = Math.max(lcsRecursive(m - 1, n, s1, s2, dp), lcsRecursive(m, n - 1, s1, s2, dp));
        }
    }

    public static int lcsTabularMethod(int m, int n, String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
