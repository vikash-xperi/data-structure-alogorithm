package dynamic;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        System.out.println(solve(arr, arr.length));
    }

    private static int solve(int[] arr, int length) {
        int[] dp = new int[length];
        int lisMaxSize = 1;
        dp[0] = 1;
        for (int i = 1; i < length; ++i) {
            int localMaxSize = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j]) {
                    localMaxSize = Math.max(localMaxSize, dp[j] + 1);
                }
            }
            dp[i] = localMaxSize;
            lisMaxSize = Math.max(lisMaxSize, dp[i]);
        }

        return lisMaxSize;
    }
}
