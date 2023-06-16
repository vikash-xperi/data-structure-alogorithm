package revision.arrays.medium;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("226"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.length() == 1) {
            if (s.charAt(0) == '0') return 0;
            return 1;
        }
        Arrays.fill(dp, -1);
        return rec(s, 0, String.valueOf(s.charAt(0)), dp) + rec(s, 1, s.substring(0, 2), dp);
    }

    public int rec(String s, int i, String tmp, int[] dp) {
        if (tmp.charAt(0) == '0' || Integer.parseInt(tmp) > 26) return 0;
        if (i >= s.length() - 1) return 1;

        if (dp[i] != -1) return dp[i];

        int left = 0, right = 0;
        if (i + 1 < s.length()) {
            left = rec(s, i + 1, String.valueOf(s.charAt(i + 1)), dp);
        }
        if (i + 3 <= s.length()) {
            right = rec(s, i + 2, s.substring(i + 1, i + 3), dp);
        }
        return dp[i] = left + right;
    }
}
