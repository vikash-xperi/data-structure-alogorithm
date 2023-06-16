package revisionback.dp;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minOperation("ABCAB", "EACB"));
        System.out.println(minOperationTabulation("ABCAB", "EACB"));
    }

    private static int minOperation(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return solve(s1, s2, dp);
    }

    private static int solve(String s1, String s2, int[][] dp) {
        if (s1.equals("") || s2.equals("")) return s1.length() > 0 ? s1.length() : s2.length();
        if (dp[s1.length() - 1][s2.length() - 1] != 0) return dp[s1.length() - 1][s2.length() - 1];
        if (s1.equals(s2)) return dp[s1.length() - 1][s2.length() - 1] = 0;
        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) return dp[s1.length() - 1][s2.length() - 1] = solve(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), dp);
        int ins = 1 + solve(s1, s2.substring(0, s2.length() - 1), dp);
        int del = 1 + solve(s1.substring(0, s1.length() - 1), s2, dp);
        int rep = 1 + solve(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), dp);
        return dp[s1.length() - 1][s2.length() - 1] = Math.min(ins, Math.min(del, rep));
    }

    private static int minOperationTabulation(String s1, String s2) {
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];
        for (int i = 0; i <= s2.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s1.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[s2.length()][s1.length()];
    }
}
