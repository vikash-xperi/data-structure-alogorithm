package backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintZigZag {

    private int maxAttempts = 1440;
    private long period = 100;
    private long maxPeriod = 120000;
    int attempt = 5;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] dp = new String[n + 1];
//        System.out.println(printZigZag(n, dp));
        PrintZigZag pzz = new PrintZigZag();
        long res = 0L;
        for (int i = 1; i <= 1440; i++) {
            res += pzz.nextMaxInterval(i, res);
        }
    }

    private static String printZigZag(int n, String[] dp) {
        if (n == 1) {
            return "1 1 1";
        }
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = n + " " + printZigZag(n - 1, dp) + " ";
        dp[n] = dp[n] + dp[n] + n;
        return dp[n];
    }

     long nextMaxInterval(int attempt, long prevInterval) {
         long interval = (long)((double)this.period * Math.pow(1.5D, (double)(attempt - 1)));
         long nextInterval = Math.min(interval, this.maxPeriod);
         long total = prevInterval + nextInterval;
         System.out.println("\nAttempt number: " + attempt + " Interval: " + (nextInterval/60000 == 0 ? nextInterval + " ms" : nextInterval/60000 + " min"));
         System.out.println("Till now total time: " + ((total/60000 == 0 ? total + " ms" : total/60000 + " min")));
         return nextInterval;
    }

}
